package exp;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class SSHConnection {
	
	private Session session;
	private String username;
	private String password;
	private String host;
	private int port;
	
	public SSHConnection(String username, String password, String host, int port) {
		this.setUsername(username);
		this.setPassword(password);
		this.setHost(host);
		this.setPort(port);
	}
	
	public Session getSession() throws JSchException {
		if (this.session == null) {
			this.session = new JSch().getSession(this.username, this.host, this.port);
			this.session.setPassword(this.password);
			this.session.setConfig("StrictHostKeyChecking", "no");
		}
		return this.session;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return this.password;
	}

	public String getHost() {
		return host;
	}

	public int getPort() {
		return port;
	}

	private void setUsername(String username) {
		this.username = username;
	}

	private void setPassword(String password) {
		this.password = password;
	}

	private void setHost(String host) {
		this.host = host;
	}

	private void setPort(int port) {
		this.port = port;
	}

}
