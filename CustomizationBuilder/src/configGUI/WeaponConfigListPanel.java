package configGUI;

import config.Config;
import config.WeaponConfig;

public class WeaponConfigListPanel extends AbstractConfigListPanel<WeaponConfig> {
	
	@Override
	protected void newConfig() {
		WeaponConfig weaponConfig = new WeaponConfig();
		weaponConfig.setName("New Weapon");
		configListModel.addElement(weaponConfig);
		
		if (config != null) {
			config.addWeaponConfig(weaponConfig);
		}
	}

	@Override
	protected void deleteConfig() {
		WeaponConfig weaponConfig = configList.getSelectedValue();
		
		configListModel.removeElement(weaponConfig);
		
		if (config != null) {
			config.removeWeaponConfig(weaponConfig);
		}
		
		if (infoListener != null) {
			infoListener.setModel(null);
		}
	}

	@Override
	protected void selectConfig() {
		if (infoListener != null) {
			WeaponConfig weaponConfig = configList.getSelectedValue();
			infoListener.setModel(weaponConfig);
		}
	}

	@Override
	public void setConfig(Config config) {
		configListModel.removeAllElements();
		
		this.config = config;
		
		for (WeaponConfig weaponConfig : config.getWeaponConfigs()) {
			configListModel.addElement(weaponConfig);
		}
	}
}
