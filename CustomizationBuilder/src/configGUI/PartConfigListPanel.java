package configGUI;

import config.Config;
import config.PartConfig;
import config.PartType;
import config.WeaponConfig;

public class PartConfigListPanel extends AbstractConfigListPanel<PartConfig> {

	
	@Override
	protected void newConfig() {
		PartConfig partConfig = new PartConfig();
		partConfig.setName("New Part");
		partConfig.setType(PartType.SIGHT);
		partConfig.setUseImage(true);
		
		configListModel.addElement(partConfig);
		
		if (config != null) {
			config.addPartConfig(partConfig);
		}
	}
	
	
	@Override
	protected void deleteConfig() {
		PartConfig partConfig = configList.getSelectedValue();
		
		configListModel.removeElement(partConfig);
		
		if (config != null) {
			config.removePartConfig(partConfig);
		}
		
		if (infoListener != null) {
			infoListener.setModel(null);
		}
	}
	
	@Override
	public void setConfig(Config config) {

		configListModel.removeAllElements();
		
		this.config = config;
		
		for (PartConfig partConfig : config.getPartConfigs()) {
			configListModel.addElement(partConfig);
		}
	}


}
