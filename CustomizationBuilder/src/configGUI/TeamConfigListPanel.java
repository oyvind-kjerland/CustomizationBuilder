package configGUI;

import config.Config;
import config.TeamConfig;
import config.WeaponConfig;

public class TeamConfigListPanel extends AbstractConfigListPanel<TeamConfig> {
	
	@Override
	public void setConfig(Config config) {
		configListModel.removeAllElements();
		
		this.config = config;
		
		for (TeamConfig teamConfig : config.getTeamConfigs()) {
			configListModel.addElement(teamConfig);
		}
	}


	@Override
	protected void newConfig() {
		TeamConfig teamConfig = new TeamConfig();
		teamConfig.setName("New Team");
		configListModel.addElement(teamConfig);
		if (config != null) {
			config.addTeamConfig(teamConfig);
		}
	}

	@Override
	protected void deleteConfig() {
		TeamConfig teamConfig = configList.getSelectedValue();
		configListModel.removeElement(teamConfig);
		
		if (config != null) {
			config.removeTeamConfig(teamConfig);
		}
		
		if (infoListener != null) {
			infoListener.setModel(null);
		}
	}
}
