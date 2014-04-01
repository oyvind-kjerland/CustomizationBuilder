package configGUI;

import javax.swing.JPanel;

import config.KitConfig;

public class KitConfigPanel extends JPanel {

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
