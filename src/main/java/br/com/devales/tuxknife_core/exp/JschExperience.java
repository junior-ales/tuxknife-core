package br.com.devales.tuxknife_core.exp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;

import br.com.devales.tuxknife_core.business.CommandTranslator;
import br.com.devales.tuxknife_core.model.Command;
import br.com.devales.tuxknife_core.model.CommandProfile;
import br.com.devales.tuxknife_core.model.CommandType;
import br.com.devales.tuxknife_core.model.ConnectionProfile;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;


public class JschExperience {

	private static final Logger LOG = Logger.getLogger("JschExperience");

	public static void main(String[] args) {
		
		try {
			CommandTranslator translator = loadCommands();
			
			ConnectionProfile cntp = new ConnectionProfile(translator.getCmdp(), "tuxknife", "tuxknife", "192.168.25.25", 22);
			
			Session session = connect(cntp);
			
			LOG.info("Connected using the command profile named: " + translator.getCmdp().getCmdpName());
			
			BufferedReader toServer = new BufferedReader(new InputStreamReader(System.in));
			BufferedReader fromServer = null;
			Channel channel;
			String line;
			String commandValue;
			
			while (true) {
				if ((commandValue = toServer.readLine()).equalsIgnoreCase(translator.getCommand(CommandType.EXIT).toString())) {
					toServer.close();
					if (fromServer != null) fromServer.close();
					break;
				}
				
				channel = session.openChannel("exec");
				((ChannelExec)channel).setCommand(commandValue);
				channel.setInputStream(null);
				channel.setOutputStream(System.out);
				channel.connect();
				
				fromServer = new BufferedReader(new InputStreamReader(channel.getInputStream()));
				
				while ((line = fromServer.readLine()) != null) {
					System.out.println(line);
				}
				channel.disconnect();
			}
	        
			LOG.info("All commands executed successfully");
			session.disconnect();
			LOG.info("Connection with server (" + cntp.getHost() + ") succesfully finished");
		} catch (JSchException e) {
			LOG.severe(e.getMessage());
		} catch (IOException e) {
			LOG.severe(e.getMessage());
		}
	}

	private static CommandTranslator loadCommands() {
		CommandProfile cmdp = new CommandProfile();
		cmdp.setCmdpName("ubuntuCommands");
		
		CommandTranslator translator = new CommandTranslator(cmdp);
		
		Command command = new Command();
		command.setType(CommandType.EXIT);
		command.setValue("OUCH");
		
		translator.setCommand(command);
		
		return translator;
	}

	private static Session connect(ConnectionProfile cntp) throws JSchException {
		Session session = new JSch().getSession(cntp.getUsername(), cntp.getHost(), cntp.getPort());
		session.setPassword(cntp.getPassword());
		session.setConfig("StrictHostKeyChecking", "no");
		
		LOG.info("Connecting...");
		session.connect();
		LOG.info("Connection with server (" + cntp.getHost() + ") succesfully done");
		return session;
	}
}
