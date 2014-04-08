package configGUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import config.Config;
import config.TeamConfig;

public class TeamConfigPanel extends JPanel {

	private Config config;
	
	
	// KitConfigPanel reference for updating teams
	private KitConfigPanel kitConfigPanel;
	
	
	private TeamConfigListPanel teamConfigListPanel;
	private TeamConfigInfoPanel teamConfigInfoPanel;
	
	public TeamConfigPanel() {
		teamConfigListPanel = new TeamConfigListPanel();
		teamConfigInfoPanel = new TeamConfigInfoPanel();
		
		teamConfigListPanel.setInfoListener(teamConfigInfoPanel);
		
		add(teamConfigListPanel);
		add(teamConfigInfoPanel);
	}
	
	public void setKitConfigPanel(KitConfigPanel kitConfigPanel) {
		this.kitConfigPanel = kitConfigPanel;
	}
	



	public void setConfig(Config config) {
		teamConfigListPanel.setConfig(config);
	}
}
