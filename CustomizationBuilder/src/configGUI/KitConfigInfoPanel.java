package configGUI;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import config.ConfigInfo;
import config.KitConfig;
import config.KitType;
import config.TeamConfig;

public class KitConfigInfoPanel extends JPanel implements ConfigInfoPanel {
	
	
	private KitConfig model;
	private JComboBox kitTypeComboBox;
	private JTextField kitNameText;
	
	public KitConfigInfoPanel() {
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
				//selectKitType();
			}
		});
		
		JLabel kitNameLabel = new JLabel("Name:");
		kitNameText = new JTextField(20);
		kitNameText.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//updateKitName();
			}
		});
		kitNameText.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent arg0) {
				//updateKitName();
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
	
	
	
	
	public void setModel(ConfigInfo configInfo) {
		if (configInfo == null) {
			kitNameText.setText("");
		} else if (configInfo != model) {
			if (model != null) {
				model.setName(kitNameText.getText());
			}
			
			model = (KitConfig)configInfo;
			
			kitNameText.setText(model.getName());
		}
		
	}
	
}
