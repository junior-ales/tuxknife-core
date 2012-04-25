package br.com.devales.tuxknife_core.model;

import java.util.ArrayList;
import java.util.List;

public class CommandProfile {

	private String cmdpName;
	private List<Command> commandList;
	
	public CommandProfile() {
		this.commandList = new ArrayList<Command>();
	}
	
	public CommandProfile(String cmdpName, List<Command> commandList) {
		this.cmdpName = cmdpName;
		this.commandList = commandList;
	}
	
	public String getCmdpName() {
		return cmdpName;
	}
	
	public void setCmdpName(String cmdpName) {
		this.cmdpName = cmdpName;
	}
	
	public List<Command> getCommandList() {
		return this.commandList;
	}
}
