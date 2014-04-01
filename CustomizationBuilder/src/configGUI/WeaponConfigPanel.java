package configGUI;

import javax.swing.JPanel;

import config.Config;
import config.WeaponConfig;

public class WeaponConfigPanel extends JPanel {

	
	private WeaponConfig model;
	private Config config;
	
	
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
	
	
	public void setConfig(Config config) {
		
	}
}
