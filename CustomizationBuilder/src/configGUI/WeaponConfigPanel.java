package configGUI;

import config.WeaponConfig;

public class WeaponConfigPanel {

	
	private WeaponConfig model;
	
	public WeaponConfigPanel() {
		
	}
	
	public WeaponConfigPanel(WeaponConfig model) {
		this();
		setModel(model);
	}
	
	
	public WeaponConfig getModel() {
		return model;
	}
	
	public void setModel(WeaponConfig model) {
		this.model = model;
	}
	
}
