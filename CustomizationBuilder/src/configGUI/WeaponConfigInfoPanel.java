package configGUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import config.ConfigInfo;
import config.WeaponConfig;

public class WeaponConfigInfoPanel extends JPanel implements ConfigInfoPanel, ActionListener, FocusListener {

	
	private WeaponConfig model;
	
	
	private JTextField nameText;
	
	
	public WeaponConfigInfoPanel() {
		setPreferredSize(new Dimension(250,250));
		
		
		
		// Labels
		JLabel nameLabel = new JLabel("Name:");
		nameText = new JTextField(20);
		nameText.addActionListener(this);
		nameText.addFocusListener(this);
		
		add(nameLabel);
		add(nameText);
		
		
	}

	@Override
	public void setModel(ConfigInfo configInfo) {
		if (configInfo == null) {
			nameText.setText("");
		} else if (configInfo != model) {			
			if (model != null) {
				// Save values before the new model is set
				model.setName(nameText.getText());
			}
			
			model = (WeaponConfig)configInfo;
			
			nameText.setText(model.getName());
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (model == null) return;
		
		if (e.getSource() == nameText) {
			model.setName(nameText.getText());
		}
		
		// Repaint parent frame
		getParent().repaint();
		
	}

	@Override
	public void focusGained(FocusEvent arg0) {
	}

	@Override
	public void focusLost(FocusEvent e) {
		if (model == null) return;
		
		if (e.getSource() == nameText) {
			model.setName(nameText.getText());
		}
		getParent().repaint();
		
	}
	
	
}
