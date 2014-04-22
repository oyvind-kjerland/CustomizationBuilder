package configGUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;

import config.Config;
import config.ConfigManager;

import builder.CustomizationBuilder;
import gui.GenericPanel;
import gui.MainFrame;

public class ConfigPanel extends GenericPanel {

	
	private static final Dimension panelSize = new Dimension(550, 300);
	
	// Tab panels
	private TeamConfigPanel teamConfigPanel;
	private KitConfigPanel kitConfigPanel;
	private WeaponConfigPanel weaponConfigPanel;
	private PartConfigPanel partConfigPanel;
	
	// Current Config file
	private File configFile;
	
	// Current Config
	private Config config;
	
	// Cache ConfigManager reference
	private ConfigManager configManager;
	
	
	
	public ConfigPanel(CustomizationBuilder customizationBuilder, MainFrame mainFrame) {
		super(customizationBuilder, mainFrame);
		configManager = customizationBuilder.getConfigManager();
		
		makeMenuBar();
		makeTabs();
		
		// Create empty config
		newConfig();

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
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		fileMenu.add(menuItem);
		
		
		menuItem = new JMenuItem("Open...");
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				openConfig();
			}
		});
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		fileMenu.add(menuItem);
		
		
		menuItem = new JMenuItem("Save");
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saveConfig();
			}
		});
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		fileMenu.add(menuItem);
		
		menuItem = new JMenuItem("Save as...");
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saveConfigAs();
			}
		});
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK | ActionEvent.SHIFT_MASK));
		fileMenu.add(menuItem);
		
		
		fileMenu.addSeparator();
		
		menuItem = new JMenuItem("Export to .py");
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				exportConfig();
			}
		});
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		fileMenu.add(menuItem);
		
		
		/*
		menuItem = new JMenuItem("Exit");
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				exit();
			}
		});
		fileMenu.add(menuItem);
		*/
		
		menuBar.add(fileMenu);
		mainFrame.setJMenuBar(menuBar);
	}
	
	private void makeTabs() {
		JTabbedPane tabs = new JTabbedPane();
		this.add(tabs);
		
		
		JPanel tabPanel;
		tabs.setPreferredSize(panelSize);
		
		// Team tab
		teamConfigPanel = new TeamConfigPanel(); 
		tabs.addTab(formatTab("Team"), teamConfigPanel);
		
		// Kit tab
		kitConfigPanel = new KitConfigPanel();
		tabs.addTab(formatTab("Kit"), kitConfigPanel);
		
		teamConfigPanel.setKitConfigPanel(kitConfigPanel);
		
		// Weapon tab
		weaponConfigPanel = new WeaponConfigPanel();
		tabs.addTab(formatTab("Weapon"), weaponConfigPanel);
		
		// Part tab
		partConfigPanel = new PartConfigPanel();
		tabs.addTab(formatTab("Part"), partConfigPanel);
		
	}
	
	private String formatTab(String name) {
		return "<html><body><table width='50'>"+name+"</table></body></html>";
	}
	
	
	private void setConfig(Config config) {
		this.config = config;
		teamConfigPanel.setConfig(config);
		kitConfigPanel.setConfig(config);
		weaponConfigPanel.setConfig(config);
		partConfigPanel.setConfig(config);
	}
	
	public Config getConfig() {
		return config;
	}
	
	
	private void newConfig() {
		if (configFile != null) {
			int response = JOptionPane.showConfirmDialog(this, 
					"Do you wish to save changes to the current Config?",
					"Save changes", JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.WARNING_MESSAGE);
			if (response == JOptionPane.YES_OPTION) {
				saveConfig();
			} else if (response == JOptionPane.NO_OPTION) {
				// Do nothing
			} else {
				return;
			}
		}
		
		config = new Config();
		configFile = null;
		mainFrame.setTitle("New Config");
		setConfig(config);
		
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
				this.configFile = configFile;
				mainFrame.setTitle(configFile.getName());
				setConfig(config);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void saveConfig() {
		if (configFile != null) {
			try {
				configManager.writeConfig(config, configFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			saveConfigAs();
		}
	}
	
	private void saveConfigAs() {
		JFileChooser fc = new ConfigFileChooser();
		File dir = new File("config");
		fc.setCurrentDirectory(dir);
		int option = fc.showSaveDialog(mainFrame);
		
		if (option == JFileChooser.APPROVE_OPTION) {
			File configFile = fc.getSelectedFile();
			try {
				configManager.writeConfig(config, configFile);
				this.configFile = configFile;
				mainFrame.setTitle(configFile.getName());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	private void exit() {
		// Cleanup
		mainFrame.setJMenuBar(null);
		showMainPanel();
	}
	
	private void exportConfig() {
		if (configFile == null) return;
		
		JFileChooser fc = new JFileChooser();
		File dir = new File("config");
		fc.setCurrentDirectory(dir);
		int option = fc.showSaveDialog(mainFrame);
		
		if (option == JFileChooser.APPROVE_OPTION) {
			File configFile = fc.getSelectedFile();
			configManager.exportConfig(config, configFile);
		}
	}
	
	private void showMainPanel() {
		mainFrame.showMainPanel();
	}

}
