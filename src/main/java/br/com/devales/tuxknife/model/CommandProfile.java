package br.com.devales.tuxknife.model;

import java.util.ArrayList;
import java.util.List;

public class CommandProfile {

	private String cmdpName;
	private List<Command> commandDictionary;
	
	public CommandProfile() {
		this.commandDictionary = new ArrayList<Command>();
	}
	
	public CommandProfile(String cmdpName, List<Command> commandDictionary) {
		this.cmdpName = cmdpName;
		this.commandDictionary = commandDictionary;
	}
	
	public String getCmdpName() {
		return cmdpName;
	}
	
	public void setCmdpName(String cmdpName) {
		this.cmdpName = cmdpName;
	}
	
	public List<Command> getCommandDictionary() {
		return this.commandDictionary;
	}
}
