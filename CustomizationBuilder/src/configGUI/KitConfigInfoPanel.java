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
	private JComboBox kitTypeComboBox;
	private JTextField kitNameText;
	
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
		kitTypeComboBox = new JComboBox(KitType.values());
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
	
	
	public JLabel makeLabel(String text) {
		JLabel label = new JLabel(text, SwingConstants.LEFT);
		label.setPreferredSize(new Dimension(50,20));
		return label;
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




	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void focusGained(FocusEvent arg0) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void focusLost(FocusEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
