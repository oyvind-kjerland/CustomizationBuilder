package node;

import java.util.ArrayList;

public class ButtonNode extends VisibleNode {

	
	protected ArrayList<ButtonCommand> commands = new ArrayList<ButtonCommand>();
	
	//
	// TODO add the textures here
	//
	
	public void addCommand(ButtonCommand command) {
		this.commands.add(command);
	}
	public void removeCommand(ButtonCommand command) {
		this.commands.remove(command);
	}
	public ArrayList<ButtonCommand> getCommands() {
		return commands;
	}
	
	
}
