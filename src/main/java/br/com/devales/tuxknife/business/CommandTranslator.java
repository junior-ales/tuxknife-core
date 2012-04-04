package br.com.devales.tuxknife.business;

import br.com.devales.tuxknife.model.Command;
import br.com.devales.tuxknife.model.CommandProfile;
import br.com.devales.tuxknife.model.CommandType;

public class CommandTranslator {
	
	private CommandProfile cmdp;
	
	public CommandTranslator() { 
		this.cmdp = new CommandProfile();
	}

	public CommandTranslator(CommandProfile cmdp) {
		this.cmdp = cmdp;
	}

	public Command getCommand(CommandType commandType) throws IllegalArgumentException {
		for (Command cmdAux : this.cmdp.getCommandList()) {
			if (cmdAux.getType().equals(commandType)) return cmdAux;
		}
		throw new IllegalArgumentException("Command not configured yet");
	}
	
	public void setCommand(Command command) {
		for (Command cmdAux : this.cmdp.getCommandList()) {
			if (cmdAux.getType().equals(command.getType())) {
				cmdAux.setValue(command.getValue());
				cmdAux.setParameter(command.getParameter());
				return;
			}
		}
		this.cmdp.getCommandList().add(command);
	}
	
	public CommandProfile getCmdp() {
		return cmdp;
	}
}
