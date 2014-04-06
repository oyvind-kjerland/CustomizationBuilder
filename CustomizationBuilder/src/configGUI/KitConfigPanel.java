package configGUI;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import config.Config;
import config.KitConfig;
import config.KitType;
import config.TeamConfig;

public class KitConfigPanel extends JPanel {

	private KitConfig model;
	private Config config;
	
	
	// Kit list
	private JList<KitConfig> kitList;
	private DefaultListModel<KitConfig> kitListModel;
	
	// Team ComboBox
	private JComboBox<TeamConfig> teamComboBox;
	private TeamConfig selectedTeamConfig;
	
	
	// Kit Info
	private JComboBox<KitType> kitTypeComboBox;
	private JTextField kitNameText;
	
	
	
	public KitConfigPanel() {
		makeKitList();
		makeKitInfo();
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
		
		
		// New button
		JButton newButton = new JButton("New");
		newButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				newKit();
			}
		});
		
		// Delete button
		JButton deleteButton = new JButton("Delete");
		deleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteKit();
			}
		});
		
		
		kitListPanel.add(teamLabel);
		kitListPanel.add(teamComboBox);
		//kitListPanel.add(kitLabel);
		kitListPanel.add(scrollPane);
		kitListPanel.add(newButton);
		kitListPanel.add(deleteButton);
		
	}

	
	private void makeKitInfo() {
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		
		JPanel kitInfoPanel = new JPanel();
		kitInfoPanel.setLayout(layout);
		kitInfoPanel.setPreferredSize(new Dimension(250, 200));
		add(kitInfoPanel);
		
		JLabel kitTypeLabel = new JLabel("KitType:");
		kitTypeComboBox = new JComboBox(KitType.values());
		kitTypeComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				selectKitType();
			}
		});
		
		JLabel kitNameLabel = new JLabel("Name:");
		kitNameText = new JTextField(20);
		kitNameText.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateKitName();
			}
		});
		kitNameText.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent arg0) {
				updateKitName();
			}
			@Override
			public void focusGained(FocusEvent arg0) {
			}
		});
		
		
		c.gridy = 0;
		c.gridx = 0;
		kitInfoPanel.add(kitNameLabel);
		c.gridx = 1;
		kitInfoPanel.add(kitNameText);
		
		c.gridy = 1;
		c.gridx = 0;
		kitInfoPanel.add(kitTypeLabel, c);		
		c.gridx = 1;
		kitInfoPanel.add(kitTypeComboBox,c);
		
		
		
	}
	
	
	public KitConfig getModel() {
		return model;
	}
	
	public void setModel(KitConfig model) {
		
		if (model == null) {
			kitNameText.setText("");
		} else {
			if (this.model != null) {
				updateKitName();
			}
			this.model = model;
			kitNameText.setText(model.getName());
			kitTypeComboBox.setSelectedItem(model.getType());
		}
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
		selectedTeamConfig = (TeamConfig)teamComboBox.getSelectedItem();
		kitListModel.removeAllElements();
		
		if (selectedTeamConfig == null) return;
		
		for (KitConfig kitConfig : selectedTeamConfig.getKitConfigs()) {
			kitListModel.addElement(kitConfig);
		}
	}
	
	private void selectKitType() {
		KitType type = (KitType)kitTypeComboBox.getSelectedItem();
		model.setType(type);
	}
	
	private void updateKitName() {
		if (model != null) {
			model.setName(kitNameText.getText());
			kitList.repaint();
		}
		
	}
	
	private void selectKit() {
		KitConfig kitConfig = kitList.getSelectedValue();
		setModel(kitConfig);
	}
	
	private void newKit() {
		if (selectedTeamConfig != null) {
			KitConfig kitConfig = new KitConfig();
			kitConfig.setName("New Kit");
			kitConfig.setType(KitType.SPECOPS);
			kitListModel.addElement(kitConfig);
			selectedTeamConfig.addKitConfig(kitConfig);
		}
	}
	
	private void deleteKit() {
		
	}
}
