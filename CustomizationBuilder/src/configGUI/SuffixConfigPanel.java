package configGUI;

import javax.swing.JPanel;

import config.Config;

public class SuffixConfigPanel extends JPanel {

	
	private SuffixConfigListPanel suffixConfigListPanel;
	
	public SuffixConfigPanel() {
		
		suffixConfigListPanel = new SuffixConfigListPanel();
		
		add(suffixConfigListPanel);
		
	}
	
	public void setConfig(Config config) {
		
	}
	
	
	
}
