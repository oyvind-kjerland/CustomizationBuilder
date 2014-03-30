package gui;

import javax.swing.JButton;
import javax.swing.JPanel;

import builder.CustomizationBuilder;

public class MainPanel extends JPanel {

	CustomizationBuilder customizationBuilder;
	
	public MainPanel(CustomizationBuilder customizationBuilder) {
		this.customizationBuilder = customizationBuilder;
		
		JButton button = new JButton("Select Config");
		add(button);
	}
	
}
