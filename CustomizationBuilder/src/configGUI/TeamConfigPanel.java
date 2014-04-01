package configGUI;

import javax.swing.JPanel;

import config.Config;
import config.TeamConfig;

public class TeamConfigPanel extends JPanel {

	private TeamConfig model;
	private Config config;
	
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
	
	public void setConfig(Config config) {
		
	}
}
