package br.com.devales.tuxknife.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

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
