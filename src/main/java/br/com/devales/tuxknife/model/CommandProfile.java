package br.com.devales.tuxknife.model;

import java.util.ArrayList;
import java.util.List;


public class CommandProfile {

	private String cmdpName;
	private List<Command> commandDictionary;
	
	public CommandProfile() {
		this.commandDictionary = new ArrayList<Command>();
	}

	public Command getCommand(CommandType commandType) {
		for (Command cmdAux : this.commandDictionary) {
			if (cmdAux.getType().equals(commandType)) return cmdAux;
		}
		throw new IllegalArgumentException("Command not configured yet");
	}
	
	public void setCommand(Command command) {
		for (Command cmdAux : this.commandDictionary) {
			if (cmdAux.getType().equals(command.getType())) {
				cmdAux.setValue(command.getValue());
				cmdAux.setParameter(command.getParameter());
				return;
			}
		}
		this.commandDictionary.add(command);
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

	public void setCommandDictionary(List<Command> commandDictionary) {
		this.commandDictionary = commandDictionary;
	}
}
