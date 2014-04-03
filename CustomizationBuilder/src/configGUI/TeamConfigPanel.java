package configGUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import config.Config;
import config.TeamConfig;

public class TeamConfigPanel extends JPanel {

	private TeamConfig model;
	private Config config;
	
	
	private JList<TeamConfig> teamList;
	private DefaultListModel<TeamConfig> teamListModel;
	
	public TeamConfigPanel() {
		makeTeamList();	
		makeTeamInfo();
	}
	
	public TeamConfigPanel(TeamConfig model) {
		this();
		setModel(model);
	}
	
	public void makeTeamList() {
		JPanel teamListPanel = new JPanel();
		teamListPanel.setPreferredSize(new Dimension(200, 250));
		add(teamListPanel);
		
		// Label
		JLabel topLabel = new JLabel("Select Team");
		teamListPanel.add(topLabel);
		
		// List
		teamList = new JList();
		teamList.setPreferredSize(new Dimension(200,190));
		teamListModel = new DefaultListModel<TeamConfig>();
		teamList.setModel(teamListModel);
		teamListPanel.add(teamList);
		
		// New button
		JButton newButton = new JButton("New");
		newButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				newTeam();
			}
		});
		teamListPanel.add(newButton);
		
		// Delete button
		JButton deleteButton = new JButton("Delete");
		deleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteTeam();
			}
		});
		teamListPanel.add(deleteButton);
	}

	public void makeTeamInfo() {
		JPanel teamInfoPanel = new JPanel();
		teamInfoPanel.setPreferredSize(new Dimension(250, 250));
		add(teamInfoPanel);
	}
	
	public TeamConfig getModel() {
		return model;
	}
	
	public void setModel(TeamConfig model) {
		this.model = model;
	}
	
	public void setConfig(Config config) {
		this.config = config;
		teamListModel.removeAllElements();
		for (TeamConfig teamConfig : config.getTeamConfigs()) {
			teamListModel.addElement(teamConfig);			
		}
	}
	
	public void newTeam() {
		TeamConfig teamConfig = new TeamConfig();
		teamConfig.setName("New Config");
		config.addTeamConfig(teamConfig);
		teamListModel.addElement(teamConfig);
	}
	
	public void deleteTeam() {
		TeamConfig teamConfig = teamList.getSelectedValue();
		if (teamConfig != null) {
			teamListModel.removeElement(teamConfig);
			config.removeTeamConfig(teamConfig);
			setModel(null);
		}
	}
	
	
}
