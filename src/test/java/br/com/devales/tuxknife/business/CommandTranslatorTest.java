package br.com.devales.tuxknife.business;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import br.com.devales.tuxknife.model.Command;
import br.com.devales.tuxknife.model.CommandProfile;
import br.com.devales.tuxknife.model.CommandType;

public class CommandTranslatorTest {
	
	private CommandProfile cmdpUbuntu;
	private CommandProfile cmdpCentOS;
	private Command exitCommandUbuntu;
	private Command exitCommandCentOS;
	
	@Before
	public void setUp() {
		this.cmdpUbuntu = new CommandProfile("Ubuntu", new ArrayList<Command>());
		this.exitCommandUbuntu = new Command(CommandType.EXIT, "OUCH", null);
		this.cmdpUbuntu.setCommand(this.exitCommandUbuntu);
		
		this.cmdpCentOS = new CommandProfile("CentOS", new ArrayList<Command>());
		this.exitCommandCentOS = new Command(CommandType.EXIT, "BYE", null);
		this.cmdpCentOS.setCommand(this.exitCommandCentOS);
	}

	@Test
	public void test() {
//		CommandTranslator translator = new CommandTranslator(this.cmdpUbuntu);
//		assertEquals(this.exitCommandUbuntu, translator.getCommand(CommandType.EXIT));
		
//		CMT has a CMDP, isn't interesting to move getCommand(CommandType) from CMDP to CMT?
	}

}
