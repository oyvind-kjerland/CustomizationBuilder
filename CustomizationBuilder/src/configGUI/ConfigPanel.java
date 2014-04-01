package configGUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import builder.CustomizationBuilder;
import gui.GenericPanel;
import gui.MainFrame;

public class ConfigPanel extends GenericPanel {

	
	private static final Dimension panelSize = new Dimension(500, 300);
	
	public ConfigPanel(CustomizationBuilder customizationBuilder, MainFrame mainFrame) {
		super(customizationBuilder, mainFrame);
		
		makeMenuBar();
		makeTabs();

	}
	
	private void makeMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		
		JMenu fileMenu = new JMenu("File");
		
		JMenuItem menuItem;
		
		menuItem = new JMenuItem("New");
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				newConfig();
			}
		});
		fileMenu.add(menuItem);
		
		
		menuItem = new JMenuItem("Open...");
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				openConfig();
			}
		});
		fileMenu.add(menuItem);
		
		
		menuItem = new JMenuItem("Save");
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saveConfig();
			}
		});
		fileMenu.add(menuItem);
		
		menuItem = new JMenuItem("Save as...");
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saveConfigAs();
			}
		});
		fileMenu.add(menuItem);
		
		
		menuBar.add(fileMenu);
		mainFrame.setJMenuBar(menuBar);
	}
	
	private void makeTabs() {
		JTabbedPane tabs = new JTabbedPane();
		this.add(tabs);
		
		
		JPanel tabPanel;
		
		// General tab
		tabPanel = new JPanel();
		tabPanel.setPreferredSize(panelSize);
		tabs.addTab(formatTab("General"), tabPanel);
		
		// Team tab
		tabPanel = new JPanel();
		tabPanel.setPreferredSize(panelSize);
		tabs.addTab(formatTab("Team"), tabPanel);
		
		// Kit tab
		tabPanel = new JPanel();
		tabPanel.setPreferredSize(panelSize);
		tabs.addTab(formatTab("Kit"), tabPanel);
		
		// Weapon tab
		tabPanel = new JPanel();
		tabPanel.setPreferredSize(panelSize);
		tabs.addTab(formatTab("Weapon"), tabPanel);
		
		// Part tab
		tabPanel = new JPanel();
		tabPanel.setPreferredSize(panelSize);
		tabs.addTab(formatTab("Part"), tabPanel);
	}
	
	private String formatTab(String name) {
		return "<html><body><table width='50'>"+name+"</table></body></html>";
	}
	
	
	
	
	private void newConfig() {
		
	}
	
	private void openConfig() {
		
	}
	
	private void saveConfig() {
		
	}
	
	private void saveConfigAs() {
		
	}
	
	private void showMainPanel() {
		mainFrame.showMainPanel();
	}

}
