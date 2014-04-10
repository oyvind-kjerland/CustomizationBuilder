package configGUI;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

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

public class KitConfigPanel extends JPanel implements PropertyChangeListener {

	private Config config;
		
	// Team ComboBox
	private JComboBox<TeamConfig> teamComboBox;
	private TeamConfig selectedTeamConfig;
	
	
	// Kit Info
	private JComboBox<KitType> kitTypeComboBox;
	
	private KitConfigListPanel kitConfigListPanel;
	private KitConfigInfoPanel kitConfigInfoPanel;
	
	
	public KitConfigPanel() {
		
		kitConfigListPanel = new KitConfigListPanel();
		kitConfigInfoPanel = new KitConfigInfoPanel();
		
		kitConfigListPanel.setInfoListener(kitConfigInfoPanel);
		
		// ComboBox
		teamComboBox = new JComboBox<TeamConfig>();
		teamComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				selectTeam();
			}
		});
		teamComboBox.setPreferredSize(new Dimension(60, 20));
		kitConfigListPanel.add(teamComboBox);
		
		add(kitConfigListPanel);
		add(kitConfigInfoPanel);
	}
	
	public void selectTeam() {
		TeamConfig teamConfig = (TeamConfig)teamComboBox.getSelectedItem();
		kitConfigListPanel.setTeamConfig(teamConfig);
	}

	
	public void setConfig(Config config) {
		if (this.config != null) {
			this.config.removePropertyChangeListener(this);
		}
		
		this.config = config;
		this.config.addPropertyChangeListener(this);
		
		updateTeams();
	}
	
	public void updateTeams() {	
		teamComboBox.removeAllItems();
		for (TeamConfig teamConfig : config.getTeamConfigs()) {
			teamComboBox.addItem(teamConfig);
		}
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		String property = evt.getPropertyName();
		if (property.equals("addTeamConfig") || property.equals("removeTeamConfig")) {
			updateTeams();
		}
	}
}
