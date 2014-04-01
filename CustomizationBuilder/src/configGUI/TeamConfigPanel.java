package configGUI;

import config.TeamConfig;

public class TeamConfigPanel {

	private TeamConfig model;
	
	public TeamConfigPanel() {
		
	}
	
	public TeamConfigPanel(TeamConfig model) {
		this();
		setModel(model);
	}
	
	public TeamConfig getModel() {
		return model;
	}
	
	public void setModel(TeamConfig model) {
		this.model = model;
	}
	
	
}
