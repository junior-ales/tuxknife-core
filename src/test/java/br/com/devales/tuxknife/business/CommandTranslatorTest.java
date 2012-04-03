package br.com.devales.tuxknife.business;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import br.com.devales.tuxknife.business.CommandTranslator;
import br.com.devales.tuxknife.model.Command;
import br.com.devales.tuxknife.model.CommandProfile;
import br.com.devales.tuxknife.model.CommandType;

public class CommandTranslatorTest {

	@Test(expected=IllegalArgumentException.class)
	public void getCommandWithNoValue() {
		CommandProfile cmdpCentOS = new CommandProfile("CentOS", new ArrayList<Command>());
		
		CommandTranslator translator = new CommandTranslator(cmdpCentOS);
		
		Command exitCommandCentOS = new Command(CommandType.EXIT, "BYE", null);
		
		translator.setCommand(exitCommandCentOS);
		
		translator.getCommand(CommandType.PWD);
	}
	
	@Test
	public void commandFlowTest() {
		CommandProfile cmdpUbuntu = new CommandProfile("Ubuntu", new ArrayList<Command>());

		CommandTranslator translator = new CommandTranslator(cmdpUbuntu);
		
		Command exitCommandUbuntu = new Command(CommandType.EXIT, "OUCH", null);
		
		translator.setCommand(exitCommandUbuntu);
		
		assertEquals(exitCommandUbuntu, translator.getCommand(CommandType.EXIT));
	}

}
