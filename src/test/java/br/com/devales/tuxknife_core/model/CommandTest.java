package br.com.devales.tuxknife_core.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.com.devales.tuxknife_core.model.Command;
import br.com.devales.tuxknife_core.model.CommandType;

public class CommandTest {

	private Command command;
	
	@Before
	public void setUp() {
		this.command = new Command();
	}
	
	@Test
	public void commandWithParamenterToStringTest() {
		command.setType(CommandType.SHUTDOWN);
		command.setValue("shutdown");
		command.setParameter("-h now");
		
		assertEquals("shutdown -h now", command.toString());
	}
	
	@Test
	public void commandWithoutParamenterToStringTest() {
		command.setType(CommandType.PWD);
		command.setValue("pwd");
		
		assertEquals("pwd", command.toString());
	}
}
