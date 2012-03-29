package exp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;


public class JschExperience {

	private static final Logger LOG = Logger.getLogger("JschExperience.class");

	public static void main(String[] args) {
		
		JSch jsch = new JSch();
		SSHInfo user = new SSHInfo("rm", "rm123");
		user.promptYesNo("yes");
		
		try {
			Session session = jsch.getSession(user.getUsername(), "vxl-srv-004", 22);
			session.setUserInfo(user);
			session.connect();
			
			Channel channel = session.openChannel("exec");
			((ChannelExec)channel).setCommand("pwd");
			channel.setInputStream(null);
//			channel.setOutputStream(System.out);
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(channel.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			channel.disconnect();
			session.disconnect();
			
		} catch (JSchException e) {
			LOG.severe(e.getMessage());
		} catch (IOException e) {
			LOG.severe(e.getMessage());
		}
	}
}
