package exp;
import com.jcraft.jsch.UserInfo;


public abstract class UserInfoImpl implements UserInfo {

	protected String username;
	protected String password;
	
	public UserInfoImpl(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public abstract String getUsername();
	public abstract String getPassword();
	public abstract String getPassphrase();
	public abstract boolean promptPassword(String message);
	public abstract boolean promptPassphrase(String message);
	public abstract boolean promptYesNo(String message);
	public abstract void showMessage(String message);
}
