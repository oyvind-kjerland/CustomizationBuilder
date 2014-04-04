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

	private TeamConfig model;
	private Config config;
	
	// TeamList
	private JList<TeamConfig> teamList;
	private DefaultListModel<TeamConfig> teamListModel;
	
	// TeamInfo
	private JTextField nameText;
	
	
	// KitConfigPanel reference for updating teams
	private KitConfigPanel kitConfigPanel;
	
	public TeamConfigPanel() {
		makeTeamList();	
		makeTeamInfo();
	}
	
	public TeamConfigPanel(TeamConfig model) {
		this();
		setModel(model);
	}
	
	public void setKitConfigPanel(KitConfigPanel kitConfigPanel) {
		this.kitConfigPanel = kitConfigPanel;
	}
	
	public void makeTeamList() {
		JPanel teamListPanel = new JPanel();
		teamListPanel.setPreferredSize(new Dimension(200, 250));
		add(teamListPanel);
		
		// Label
		JLabel topLabel = new JLabel("Select Team");
		
		
		
		// List
		teamList = new JList<TeamConfig>();
		//teamList.setPreferredSize(new Dimension(200,190));
		teamListModel = new DefaultListModel<TeamConfig>();
		teamList.setModel(teamListModel);
		teamList.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				selectTeam();
			}
		});
		
		JScrollPane scrollPane = new JScrollPane(teamList);
		scrollPane.setPreferredSize(new Dimension(200, 190));

		
		// New button
		JButton newButton = new JButton("New");
		newButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				newTeam();
			}
		});
		
		// Delete button
		JButton deleteButton = new JButton("Delete");
		deleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteTeam();
			}
		});

		
		teamListPanel.add(topLabel);
		teamListPanel.add(scrollPane);
		teamListPanel.add(newButton);
		teamListPanel.add(deleteButton);
	
	}

	public void makeTeamInfo() {
		JPanel teamInfoPanel = new JPanel();
		teamInfoPanel.setPreferredSize(new Dimension(250, 250));
		add(teamInfoPanel);
		
		// Name
		JLabel nameLabel = new JLabel("Name:");
		nameText = new JTextField(20);
		nameText.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateTeamName();
			}
		});
		nameText.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent arg0) {
				updateTeamName();
			}

			@Override
			public void focusGained(FocusEvent e) {
			}
		});
		
		teamInfoPanel.add(nameLabel);
		teamInfoPanel.add(nameText);
		
	}
	
	public TeamConfig getModel() {
		return model;
	}
	
	public void setModel(TeamConfig model) {
		if (model == null) {
			nameText.setText("");
		} else {
			if (this.model != null) {
				updateTeamName();
			}
			this.model = model;
			nameText.setText(model.getName());
		}
	}
	
	public void setConfig(Config config) {
		this.config = config;
		teamListModel.removeAllElements();
		for (TeamConfig teamConfig : config.getTeamConfigs()) {
			teamListModel.addElement(teamConfig);			
		}
	}
	
	private void updateTeamName() {
		if (model == null) return;
		String name = nameText.getText();
		model.setName(name);
		teamList.repaint();
	}
	
	private void selectTeam() {
		TeamConfig teamConfig = teamList.getSelectedValue();
		setModel(teamConfig);
	}
	
	private void newTeam() {
		TeamConfig teamConfig = new TeamConfig();
		teamConfig.setName("New Team");
		config.addTeamConfig(teamConfig);
		teamListModel.addElement(teamConfig);
		kitConfigPanel.updateTeams();
	}
	
	private void deleteTeam() {
		TeamConfig teamConfig = teamList.getSelectedValue();
		if (teamConfig != null) {
			teamListModel.removeElement(teamConfig);
			config.removeTeamConfig(teamConfig);
			setModel(null);
			kitConfigPanel.updateTeams();
		}
	}
	
	
}
