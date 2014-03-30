package gui;

import javax.swing.JPanel;

import builder.CustomizationBuilder;

public class GenericPanel extends JPanel {

	protected CustomizationBuilder customizationBuilder;
	protected MainFrame mainFrame;
	
	public GenericPanel(CustomizationBuilder customizationBuilder, MainFrame mainFrame) {
		this.customizationBuilder = customizationBuilder;
		this.mainFrame = mainFrame;
	}
	
}
