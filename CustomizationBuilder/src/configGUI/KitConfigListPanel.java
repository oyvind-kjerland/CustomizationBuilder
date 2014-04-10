package configGUI;

import config.Config;
import config.KitConfig;
import config.KitType;
import config.TeamConfig;

public class KitConfigListPanel extends AbstractConfigListPanel<KitConfig> {

	private TeamConfig teamConfig;
	
	@Override
	public void setConfig(Config config) {
	}
	
	public void setTeamConfig(TeamConfig teamConfig) {
		configListModel.removeAllElements();
		
		this.teamConfig = teamConfig;
		if (teamConfig != null) {
			for (KitConfig kitConfig : teamConfig.getKitConfigs()) {
				configListModel.addElement(kitConfig);
			}
		}
	}
	

	@Override
	protected void newConfig() {
		if (teamConfig == null) return;
		
		KitConfig kitConfig = new KitConfig();
		kitConfig.setName("New Kit");
		kitConfig.setType(KitType.SPECOPS);
		
		configListModel.addElement(kitConfig);
		teamConfig.addKitConfig(kitConfig);
		
		
	}

	@Override
	protected void deleteConfig() {
		// TODO Auto-generated method stub
		
	}
	
	

}
