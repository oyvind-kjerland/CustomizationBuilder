package configGUI;

import javax.swing.JPanel;

import config.Config;

public class SuffixConfigPanel extends JPanel {

	
	private SuffixConfigListPanel suffixConfigListPanel;
	private SuffixConfigInfoPanel suffixConfigInfoPanel;
	
	public SuffixConfigPanel() {
		
		suffixConfigListPanel = new SuffixConfigListPanel();
		suffixConfigInfoPanel = new SuffixConfigInfoPanel();
		
		suffixConfigListPanel.setInfoListener(suffixConfigInfoPanel);
		
		add(suffixConfigListPanel);
		add(suffixConfigInfoPanel);
		
	}
	
	public void setConfig(Config config) {
		suffixConfigListPanel.setConfig(config);
	}
	
	
	
}
