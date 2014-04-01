package configGUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import config.Config;
import config.ConfigManager;

import builder.CustomizationBuilder;
import gui.GenericPanel;
import gui.MainFrame;

public class ConfigPanel extends GenericPanel {

	
	private static final Dimension panelSize = new Dimension(500, 300);
	
	// Tab panels
	private GeneralConfigPanel generalConfigPanel;
	private TeamConfigPanel teamConfigPanel;
	private KitConfigPanel kitConfigPanel;
	private WeaponConfigPanel weaponConfigPanel;
	
	
	// Current Config path
	private File currentConfigFile;
	
	
	// Cache ConfigManager reference
	private ConfigManager configManager;
	
	
	public ConfigPanel(CustomizationBuilder customizationBuilder, MainFrame mainFrame) {
		super(customizationBuilder, mainFrame);
		configManager = customizationBuilder.getConfigManager();
		
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
		
		
		fileMenu.addSeparator();
		
		
		menuItem = new JMenuItem("Exit");
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				exit();
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
		tabs.setPreferredSize(panelSize);
		
		// General tab
		//generalConfigPanel = new GeneralConfigPanel();
		//tabs.addTab(formatTab("General"), generalConfigPanel);
		
		// Team tab
		teamConfigPanel = new TeamConfigPanel(); 
		tabs.addTab(formatTab("Team"), teamConfigPanel);
		
		// Kit tab
		kitConfigPanel = new KitConfigPanel();
		tabs.addTab(formatTab("Kit"), kitConfigPanel);
		
		// Weapon tab
		weaponConfigPanel = new WeaponConfigPanel();
		tabs.addTab(formatTab("Weapon"), weaponConfigPanel);
		
	}
	
	private String formatTab(String name) {
		return "<html><body><table width='50'>"+name+"</table></body></html>";
	}
	
	
	private void setConfig(Config config) {
		
	}
	
	
	private void newConfig() {
		
	}
	
	private void openConfig() {
		JFileChooser fc = new JFileChooser();
		File dir = new File("config");
		fc.setCurrentDirectory(dir);
		int option = fc.showOpenDialog(mainFrame);
		
		if (option == JFileChooser.APPROVE_OPTION) {
			File configFile = fc.getSelectedFile();
			try {
				Config config = configManager.readConfig(configFile);
				currentConfigFile = configFile;
				mainFrame.setTitle(configFile.getName());
				setConfig(config);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void saveConfig() {
		
	}
	
	private void saveConfigAs() {
		
	}
	
	private void exit() {
		// Cleanup
		mainFrame.setJMenuBar(null);
		showMainPanel();
	}
	
	private void showMainPanel() {
		mainFrame.showMainPanel();
	}

}
