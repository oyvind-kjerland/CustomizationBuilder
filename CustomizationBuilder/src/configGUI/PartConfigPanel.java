package configGUI;

import javax.swing.JPanel;

import config.Config;

public class PartConfigPanel extends JPanel {

	PartConfigListPanel partConfigListPanel;
	PartConfigInfoPanel partConfigInfoPanel;
	
	public PartConfigPanel() {
		
		partConfigListPanel = new PartConfigListPanel();
		add(partConfigListPanel);
		
		partConfigInfoPanel = new PartConfigInfoPanel();
		add(partConfigInfoPanel);
		
		partConfigListPanel.setInfoListener(partConfigInfoPanel);
		
	}
	
	
	public void setConfig(Config config) {
		partConfigListPanel.setConfig(config);
	}
}
