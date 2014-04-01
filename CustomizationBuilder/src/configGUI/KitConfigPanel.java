package configGUI;

import javax.swing.JPanel;

import config.Config;
import config.KitConfig;

public class KitConfigPanel extends JPanel {

	private KitConfig model;
	private Config config;
	
	
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
	
	public void setConfig(Config config) {
		
	}
	
}
