package node;

public class ButtonCommand {

	private String command;
	private ButtonEvent event;
	
	public ButtonCommand(String command, ButtonEvent event) {
		this.command = command;
		this.event = event;
	}
	
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	
	public ButtonEvent getEvent() {
		return event;
	}
	public void setEvent(ButtonEvent event) {
		this.event = event;
	}
}
