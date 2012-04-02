package br.com.devales.tuxknife.model;

public class Command {

	private CommandType type;
	private String value;
	private String parameter;
	
	public Command() {}
	
	public Command(CommandType type, String value, String parameter) {
		this.type = type;
		this.value = value;
		this.parameter = parameter;
	}
	
	public CommandType getType() {
		return type;
	}
	
	public void setType(CommandType type) {
		this.type = type;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public String getParameter() {
		return parameter;
	}
	
	public void setParameter(String parameter) {
		this.parameter = parameter;
	}
}
