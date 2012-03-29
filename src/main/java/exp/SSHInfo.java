package exp;


public class SSHInfo extends UserInfoImpl {
	
	public SSHInfo(String username, String password) {
		super(username, password);
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
		return answer.equalsIgnoreCase("yes");
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

}
