package br.com.devales.tuxknife.business;

import java.util.logging.Logger;

import br.com.devales.tuxknife.model.ConnectionProfile;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class Controller {

	private final Session session;
	private final ConnectionProfile cntp;
	private static final Logger LOG = Logger.getLogger("Controller");

	public Controller(final ConnectionProfile cntp) throws JSchException {
		this.cntp = cntp;
		this.session = new JSch().getSession(this.cntp.getUsername(), this.cntp.getHost(), this.cntp.getPort());
		this.session.setPassword(this.cntp.getPassword());
		this.session.setConfig("StrictHostKeyChecking", "no");
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

}
