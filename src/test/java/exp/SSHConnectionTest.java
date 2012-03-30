package exp;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class SSHConnectionTest {

	private Session session;
	
	@Before
	public void setup() throws JSchException {
		SSHConnection conn = new SSHConnection("tuxknife", "tuxknife", "192.168.25.25", 22);
		this.session = conn.getSession();
		this.session.connect();
	}
	
	@After
	public void tearDown() throws JSchException {
		if (this.session.isConnected()) this.session.disconnect();
	}
	
	@Test
	public void testIfSSHConnectionIsConnected() throws JSchException {
		assertTrue(this.session.isConnected());
	}
	
}
