package configGUI;

import javax.swing.JPanel;

import config.WeaponConfig;

public class WeaponConfigPanel extends JPanel {

	
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
