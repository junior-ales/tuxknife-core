package exp;
import com.jcraft.jsch.HostKey;
import com.jcraft.jsch.HostKeyRepository;
import com.jcraft.jsch.UserInfo;


public class HostImpl implements HostKeyRepository {

	@Override
	public int check(String host, byte[] key) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void add(HostKey hostkey, UserInfo ui) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(String host, String type) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(String host, String type, byte[] key) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getKnownHostsRepositoryID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HostKey[] getHostKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HostKey[] getHostKey(String host, String type) {
		// TODO Auto-generated method stub
		return null;
	}

}
