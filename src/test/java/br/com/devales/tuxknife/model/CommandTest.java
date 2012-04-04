package br.com.devales.tuxknife.model;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CommandTest {

	@Test
	public void commandWithParamenterToStringTest() {
		Command command = new Command();
		command.setType(CommandType.EXIT);
		command.setValue("shutdown");
		command.setParameter("-h now");
		
		assertEquals("shutdown -h now", command.toString());
	}
	
	@Test
	public void commandWithoutParamenterToStringTest() {
		Command command = new Command();
		command.setType(CommandType.PWD);
		command.setValue("pwd");
		
		assertEquals("pwd", command.toString());
	}
}
