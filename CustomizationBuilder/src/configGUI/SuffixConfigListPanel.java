package configGUI;

import config.Config;
import config.PartConfig;
import config.PartType;
import config.SuffixConfig;

public class SuffixConfigListPanel extends AbstractConfigListPanel<SuffixConfig> {

	@Override
	public void setConfig(Config config) {
		
		configListModel.removeAllElements();
		
		this.config = config;
		
		for (SuffixConfig suffixConfig : config.getSuffixConfigs()) {
			configListModel.addElement(suffixConfig);
		}
	}

	@Override
	protected void newConfig() {
		SuffixConfig suffixConfig = new SuffixConfig();
		suffixConfig.setName("New Suffix");
		
		configListModel.addElement(suffixConfig);
		if (config != null) {
			config.addSuffixConfig(suffixConfig);
		}
		
	}

	@Override
	protected void deleteConfig() {
		SuffixConfig suffixConfig = configList.getSelectedValue();
		
		configListModel.removeElement(suffixConfig);
		
		if (config != null) {
			config.removeSuffixConfig(suffixConfig);
		}
		
		if (infoListener != null) {
			infoListener.setModel(null);
		}
		
	}
	
	
	
	
}
