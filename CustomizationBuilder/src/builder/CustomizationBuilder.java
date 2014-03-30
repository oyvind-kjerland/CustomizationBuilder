package builder;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import config.ConfigManager;

import gui.MainFrame;

public class CustomizationBuilder {

	private ConfigManager configManager;
	
	public CustomizationBuilder() {
		
		// Set look and feel to system
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		configManager = new ConfigManager();
	
		// Create main frame
		MainFrame mainFrame = new MainFrame(this);
	}
	
	public ConfigManager getConfigManager() {
		return configManager;
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		CustomizationBuilder cutomizationBuilder = new CustomizationBuilder();
	}
}
