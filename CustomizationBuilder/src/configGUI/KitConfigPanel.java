package configGUI;

import config.KitConfig;

public class KitConfigPanel {

	private KitConfig model;
	
	public KitConfigPanel() {
		
	}
	
	public KitConfigPanel(KitConfig model) {
		this();
		setModel(model);
	}
	
	public KitConfig getModel() {
		return model;
	}
	
	public void setModel(KitConfig model) {
		this.model = model;
	}
	
}
