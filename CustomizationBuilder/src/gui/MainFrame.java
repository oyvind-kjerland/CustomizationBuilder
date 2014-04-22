package gui;

import java.awt.Container;

import javax.swing.JFrame;

import configGUI.ConfigPanel;
import emulatorGUI.EmulatorPanel;

import builder.CustomizationBuilder;

public class MainFrame extends JFrame {


	private CustomizationBuilder customizationBuilder;
	private Container contentPane;
	
	public MainFrame(CustomizationBuilder customizationBuilder) {
		
		this.customizationBuilder = customizationBuilder;
		
		this.contentPane = this.getContentPane();
		
		setTitle("CustomizationBuilder");
		setVisible(true);
		//showMainPanel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		showConfigPanel();
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
	
	public void showEmulatorPanel() {
		contentPane.removeAll();
		contentPane.add(new EmulatorPanel(customizationBuilder, this));
		pack();
	}
	
}
