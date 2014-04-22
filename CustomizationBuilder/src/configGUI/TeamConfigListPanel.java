package configGUI;

import config.Config;
import config.KitConfig;
import config.KitType;
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
		if (config == null) return;
		
		TeamConfig teamConfig = new TeamConfig();
		teamConfig.setName("New Team");
		
		// Add kits to team
		for (KitType type : KitType.values()) {
			KitConfig kitConfig = new KitConfig();
			kitConfig.setName(type.name());
			kitConfig.setType(type);
			teamConfig.addKitConfig(kitConfig);
		}
		
		
		configListModel.addElement(teamConfig);
		config.addTeamConfig(teamConfig);

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
