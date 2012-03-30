package exp;

import com.jcraft.jsch.UserInfo;


public class ConnectionData implements UserInfo {
	
	private String username;
	private String password;
	private String host;
	private int port;
	

	public ConnectionData(String username, String password, String host, int port) {
		this.setUsername(username);
		this.setPassword(password);
		this.setHost(host);
		this.setPort(port);
	}

	@Override
	public String getPassphrase() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean promptPassphrase(String arg0) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean promptPassword(String arg0) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean promptYesNo(String answer) {
		return true;
	}

	@Override
	public void showMessage(String arg0) {
		// TODO Auto-generated method stub
	}

	public String getUsername() {
		return username;
	}
	
	@Override
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
