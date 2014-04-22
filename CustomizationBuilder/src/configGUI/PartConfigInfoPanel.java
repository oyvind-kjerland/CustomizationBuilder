package configGUI;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import config.ConfigInfo;
import config.PartConfig;
import config.PartType;
import config.WeaponConfig;

public class PartConfigInfoPanel extends AbstractConfigInfoPanel implements ActionListener, FocusListener {

	
	private PartConfig model;
	
	private JTextField nameText;
	private JComboBox<PartType> typeComboBox;
	
	private final Dimension infoFieldSize = new Dimension(150,20);
	
	public PartConfigInfoPanel() {
		super();
		
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(0, 0, 5, 0);
		setLayout(layout);
		
		// Labels
		JLabel nameLabel = makeLabel("Name:");
		nameText = new JTextField();
		nameText.addActionListener(this);
		nameText.addFocusListener(this);
		nameText.setPreferredSize(infoFieldSize);
		
		JLabel typeLabel = makeLabel("Type:");
		typeComboBox  = new JComboBox(PartType.values());
		typeComboBox.setPreferredSize(infoFieldSize);
		typeComboBox.addActionListener(this);

		
		c.gridy = 0;
		c.gridx = 0;
		add(nameLabel, c);
		c.gridx = 1;
		add(nameText, c);
		
		c.gridy = 1;
		c.gridx = 0;
		add(typeLabel, c);
		c.gridx = 1;
		add(typeComboBox, c);
		

		
		
		
		
	}
	
	
	@Override
	public void setModel(ConfigInfo configInfo) {
		if (configInfo == null) {
			nameText.setText("");
		} else {
			if (model != null) {
				// Save values before the new model is set
				model.setName(nameText.getText());
				
				PartType type = (PartType)typeComboBox.getSelectedItem();
				model.setType(type);
			}
			
			model = (PartConfig)configInfo;
			
			nameText.setText(model.getName());
			typeComboBox.setSelectedItem(model.getType());
		}
	}


	@Override
	public void actionPerformed(ActionEvent evt) {
		if (model == null) return;
		
		if (evt.getSource() == nameText) {
			model.setName(nameText.getText());
		} else if (evt.getSource() == typeComboBox) {
			PartType type = (PartType)typeComboBox.getSelectedItem();
			model.setType(type);
		}
		
		getParent().repaint();
	}


	@Override
	public void focusGained(FocusEvent arg0) {

	}


	@Override
	public void focusLost(FocusEvent evt) {
		if (model == null) return;
		
		if (evt.getSource() == nameText) {
			model.setName(nameText.getText());
			
			PartType type = (PartType)typeComboBox.getSelectedItem();
			model.setType(type);
		}
		
		getParent().repaint();
	}
	
	
	
	

}
