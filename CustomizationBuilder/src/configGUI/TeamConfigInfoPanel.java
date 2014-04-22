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
import config.TeamConfig;

public class TeamConfigInfoPanel extends AbstractConfigInfoPanel implements ActionListener, FocusListener {

	
	private TeamConfig model;

	
	private JTextField nameText;
	
	public TeamConfigInfoPanel() {
		super();
		
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
				model.setName(nameText.getText());
			}
			
			model = (TeamConfig)configInfo;
			
			nameText.setText(model.getName());
		}
		
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if (model == null) return;
		
		if (e.getSource() == nameText) {
			model.setName(nameText.getText());
		}
		
		getParent().repaint();
	}
	
	
	
}
