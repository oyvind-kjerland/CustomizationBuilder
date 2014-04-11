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
import javax.swing.SwingConstants;

import config.ConfigInfo;
import config.KitConfig;
import config.KitType;
import config.TeamConfig;

public class KitConfigInfoPanel extends AbstractConfigInfoPanel implements ActionListener, FocusListener {
	
	
	private KitConfig model;
	private JTextField kitNameText;
	private JComboBox<KitType> kitTypeComboBox;
	
	public KitConfigInfoPanel() {
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		
		setPreferredSize(new Dimension(250, 250));
		setLayout(layout);
		
		JLabel kitNameLabel = makeLabel("Name:");
		kitNameText = new JTextField(20);
		kitNameText.addActionListener(this);
		kitNameText.addFocusListener(this);

		JLabel kitTypeLabel = makeLabel("Type:");
		kitTypeComboBox = new JComboBox<KitType>(KitType.values());
		kitTypeComboBox.addActionListener(this);
		
		c.gridy = 0;
		c.gridx = 0;
		add(kitNameLabel, c);
		c.gridx = 1;
		add(kitNameText, c);
		
		c.gridy = 1;
		c.gridx = 0;
		add(kitTypeLabel, c);
		c.gridx = 1;
		add(kitTypeComboBox, c);
	}
	
	
	public void setModel(ConfigInfo configInfo) {
		if (configInfo == null) {
			kitNameText.setText("");
			kitTypeComboBox.setSelectedItem(KitType.SPECOPS);
		} else if (configInfo != model) {
			if (model != null) {
				model.setName(kitNameText.getText());
				model.setType((KitType)kitTypeComboBox.getSelectedItem());
			}
			
			model = (KitConfig)configInfo;
			
			kitNameText.setText(model.getName());
			kitTypeComboBox.setSelectedItem(model.getType());
		}
		
	}



	// Lsteners
	@Override
	public void actionPerformed(ActionEvent evt) {
		updateField(evt.getSource());
	}

	@Override
	public void focusGained(FocusEvent arg0) {
	}

	@Override
	public void focusLost(FocusEvent evt) {
		updateField(evt.getSource());
	}
	
	
	private void updateField(Object source) {
		if (model == null) return;
		
		if (source == kitNameText) {
			model.setName(kitNameText.getText());
		} else if (source == kitTypeComboBox) {
			model.setType((KitType)kitTypeComboBox.getSelectedItem());
		}
		
		getParent().repaint();
	}
	
	
}
