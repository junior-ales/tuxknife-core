package br.com.devales.tuxknife.model;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class CommandProfileTest {

	@Test
	public void testCreatingAndGettingCommand() {
		
		String commandValue = "pwd";
		CommandProfile ubuntu = new CommandProfile();
		
		Command aux = new Command();
		aux.setType(CommandType.PWD);
		aux.setValue(commandValue);
		List<Command> commandDictionary = ubuntu.getCommandDictionary();
		commandDictionary.add(aux);
		
		Command command = ubuntu.getCommand(CommandType.PWD);
		assertEquals(commandValue, command.getValue());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void getCommandWithNoValue() {
		CommandProfile ubuntu = new CommandProfile();
		Command command = ubuntu.getCommand(CommandType.PWD);
		assertNotNull(command.getValue());
	}
	
	@Test
	public void setCommand() {
		Command command = new Command();
		command.setType(CommandType.EXIT);
		command.setValue("OUCH");
		
		CommandProfile cmdp = new CommandProfile();
		cmdp.setCommand(command);
		assertEquals(cmdp.getCommand(CommandType.EXIT), command);
	}
}
