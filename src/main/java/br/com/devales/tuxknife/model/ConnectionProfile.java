package br.com.devales.tuxknife.model;


public class ConnectionProfile {
	
	private String cntpName;
	private String username;
	private String password;
	private String host;
	private Integer port;
	
	public ConnectionProfile(String username, String host, Integer port) {
		this.username = username;
		this.host = host;
		this.port = port;
		this.cntpName = new StringBuffer().append(username).append("@").append(host).append(":").append(port).toString();
	}
	
	public ConnectionProfile(String username, String password, String host, Integer port) {
		this(username, host, port);
		this.password = password;
	}
	
	public ConnectionProfile(String cntpName, String password, String username, String host, Integer port) {
		this(username, password, host, port);
		this.cntpName = cntpName;
	}

	public String getCntpName() {
		return cntpName;
	}
	
	public void setCntpName(String cntpName) {
		this.cntpName = cntpName;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public String getPassword() {
		return this.password;
	}

	public String getHost() {
		return this.host;
	}

	public Integer getPort() {
		return this.port;
	}

}