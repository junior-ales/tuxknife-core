package br.com.devales.tuxknife.business;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.jcraft.jsch.JSchException;

import br.com.devales.tuxknife.model.Command;
import br.com.devales.tuxknife.model.CommandProfile;
import br.com.devales.tuxknife.model.CommandType;
import br.com.devales.tuxknife.model.ConnectionProfile;

public class ControllerTest {

	private Controller controller;
	private CommandTranslator translator;

	@Before
	public void setUp() throws JSchException {
		this.translator = this.createTranslator();
		this.controller = new Controller(new ConnectionProfile(this.translator.getCmdp(), "tuxknife", "tuxknife", "192.168.25.25", 22));
	}

	private CommandTranslator createTranslator() {
		final CommandProfile cmdp = new CommandProfile();
		cmdp.setCmdpName("ubuntuCommands");
		final CommandTranslator translator = new CommandTranslator(cmdp);
		final Command command = new Command();
		command.setType(CommandType.EXIT);
		command.setValue("OUCH");
		translator.setCommand(command);
		return translator;
	}

	@After
	public void tearDown() {
		if (this.controller.isConnected())
			this.controller.disconnect();
	}

	@Test
	public void connectingTest() throws JSchException {
		assertFalse(this.controller.isConnected());
		this.controller.connect();
		assertTrue(this.controller.isConnected());
	}

	@Test
	public void disconnectingTest() throws JSchException {
		this.controller.connect();
		this.controller.disconnect();
		assertFalse(this.controller.isConnected());
	}

	
}
