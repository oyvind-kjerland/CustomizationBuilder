package gui;

import java.awt.Container;

import javax.swing.JFrame;

import configGUI.ConfigPanel;

import builder.CustomizationBuilder;

public class MainFrame extends JFrame {


	private CustomizationBuilder customizationBuilder;
	private Container contentPane;
	
	public MainFrame(CustomizationBuilder customizationBuilder) {
		
		this.customizationBuilder = customizationBuilder;
		
		this.contentPane = this.getContentPane();
		
		setTitle("CustomizationBuilder");
		setVisible(true);
		showMainPanel();
		
	}
	
	
	public void showMainPanel() {
		contentPane.removeAll();
		contentPane.add(new MainPanel(customizationBuilder, this));
		pack();
	}
	
	public void showConfigPanel() {
		contentPane.removeAll();
		contentPane.add(new ConfigPanel(customizationBuilder, this));
		pack();
	}
	
}
