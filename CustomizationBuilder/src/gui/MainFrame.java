package gui;

import javax.swing.JFrame;

import builder.CustomizationBuilder;

public class MainFrame extends JFrame {

	private CustomizationBuilder customizationBuilder;
	
	public MainFrame(CustomizationBuilder customizationBuilder) {
		
		this.customizationBuilder = customizationBuilder;
		
		this.setTitle("CustomizationBuilder");
		this.setVisible(true);
		showMainPanel();
		
	}
	
	public void showMainPanel() {
		
		MainPanel mainPanel = new MainPanel(customizationBuilder, this);
		this.add(mainPanel);
		this.pack();
		//this.revalidate();
		
	}
	
}
