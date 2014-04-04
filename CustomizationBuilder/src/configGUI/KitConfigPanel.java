package configGUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import config.Config;
import config.KitConfig;
import config.TeamConfig;

public class KitConfigPanel extends JPanel {

	private KitConfig model;
	private Config config;
	
	
	// Kit list
	private JList<KitConfig> kitList;
	private DefaultListModel<KitConfig> kitListModel;
	private JComboBox<TeamConfig> teamComboBox;
	
	
	public KitConfigPanel() {
		makeKitList();
		makeKitInfo();
	}
	
	private void makeKitInfo() {
		JPanel kitInfoPanel = new JPanel();
		kitInfoPanel.setPreferredSize(new Dimension(250, 200));
		add(kitInfoPanel);
		
	}

	public KitConfigPanel(KitConfig model) {
		this();
		setModel(model);
	}
	
	private void makeKitList() {
		JPanel kitListPanel = new JPanel();
		kitListPanel.setPreferredSize(new Dimension(200,250));
		add(kitListPanel);
		
		
		// Label
		JLabel kitLabel = new JLabel("Select Kit");
		JLabel teamLabel = new JLabel("Select Team");
		
		// ComboBox
		teamComboBox = new JComboBox<TeamConfig>();
		teamComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				selectTeam();
			}
		});
		teamComboBox.setPreferredSize(new Dimension(100, 20));
		
		// List
		kitList = new JList<KitConfig>();
		kitListModel = new DefaultListModel<KitConfig>();
		kitList.setModel(kitListModel);
		kitList.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				selectKit();
			}
		});
		
		JScrollPane scrollPane = new JScrollPane(kitList);
		scrollPane.setPreferredSize(new Dimension(200, 190));
		
		kitListPanel.add(teamLabel);
		kitListPanel.add(teamComboBox);
		//kitListPanel.add(kitLabel);
		kitListPanel.add(scrollPane);
		
	}
	
	public KitConfig getModel() {
		return model;
	}
	
	public void setModel(KitConfig model) {
		this.model = model;
	}
	
	public void setConfig(Config config) {
		this.config = config;
		updateTeams();
	}
	
	public void updateTeams() {		
		
		teamComboBox.removeAllItems();
		for (TeamConfig teamConfig : config.getTeamConfigs()) {
			teamComboBox.addItem(teamConfig);
		}
	}
	
	private void selectTeam() {
		
	}
	
	private void selectKit() {
		
	}
	
}
