package br.com.devales.tuxknife.business;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;

import br.com.devales.tuxknife.model.Command;
import br.com.devales.tuxknife.model.CommandType;
import br.com.devales.tuxknife.model.ConnectionProfile;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class Controller {

	private final Session session;
	private final ConnectionProfile cntp;
	private final CommandTranslator translator;
	private static final Logger LOG = Logger.getLogger("Controller");

	public Controller(final ConnectionProfile cntp) throws JSchException {
		this.cntp = cntp;
		this.session = new JSch().getSession(this.cntp.getUsername(), this.cntp.getHost(), this.cntp.getPort());
		this.session.setPassword(this.cntp.getPassword());
		this.session.setConfig("StrictHostKeyChecking", "no");
		this.translator = new CommandTranslator(cntp.getCmdp());
	}

	public void connect() throws JSchException {
		LOG.info("Connecting...");
		this.session.connect();
		LOG.info("Connection with server (" + this.cntp.getHost() + ") succesfully done using the command profile named: " + this.cntp.getCmdp().getCmdpName());
	}

	public void disconnect() {
		this.session.disconnect();
		LOG.info("Connection with server (" + this.cntp.getHost() + ") succesfully finished");
	}

	public boolean isConnected() {
		return this.session.isConnected();
	}

	public String commit(final CommandType commandType) throws JSchException, IOException {
		final Channel channel = this.openChannel(this.translator.getCommand(commandType));
		return this.getCommandReturn(channel);
	}

	private String getCommandReturn(final Channel channel) throws IOException {
		String aux;
		final StringBuffer buffer = new StringBuffer();
		final BufferedReader fromServer = new BufferedReader(new InputStreamReader(channel.getInputStream()));
		
		while ((aux = fromServer.readLine()) != null) {
			buffer.append(aux).append("\n");
		}
		channel.disconnect();
		
		return buffer.toString().replaceAll("\\n$","");
	}

	private Channel openChannel(final Command command) throws JSchException {
		final Channel channel = this.session.openChannel("exec");
		((ChannelExec)channel).setCommand(command.toString());
		channel.setInputStream(null);
		channel.setOutputStream(System.out);
		channel.connect();
		
		return channel;
	}

}
