package configGUI;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

import config.ConfigInfo;
import config.PartConfig;
import config.PartType;
import config.SuffixConfig;

public class SuffixConfigInfoPanel extends AbstractConfigInfoPanel implements ActionListener, FocusListener {

	private SuffixConfig model;
	
	private JTextField nameText;
	private GenericPartPanel skinPanel;
	
	
	private final Dimension infoFieldSize = new Dimension(150,20);
	
	public SuffixConfigInfoPanel() {
		super();
		
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(0, 0, 5, 0);
		setLayout(layout);
	
		// Name
		JLabel nameLabel = makeLabel("Name:");
		nameText = new JTextField();
		nameText.addActionListener(this);
		nameText.addFocusListener(this);
		nameText.setPreferredSize(infoFieldSize);	
		
		
		// Skin
		JLabel skinLabel = makeLabel("Skin:");
		skinPanel = new GenericPartPanel(PartType.SKIN, true);
		
		
		c.gridy = 0;
		c.gridx = 0;
		add(nameLabel, c);
		c.gridx = 1;
		add(nameText, c);
		
		c.gridy = 1;
		c.gridx = 0;
		add(skinLabel, c);
		c.gridx = 1;
		add(skinPanel, c);
	}
	
	@Override
	public void setModel(ConfigInfo configInfo) {
		if (configInfo == null) {
			nameText.setText("");
		} else {
			if (model != null) {
				// Save values before the new model is set
				model.setName(nameText.getText());
			}
			
			model = (SuffixConfig)configInfo;
			
			nameText.setText(model.getName());
			
			skinPanel.setSuffixModel(model);
		}
	}

	@Override
	public void focusGained(FocusEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent evt) {
		if (model == null) return;
		
		if (evt.getSource() == nameText) {
			model.setName(nameText.getText());
		}
		
		getParent().repaint();
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		if (model == null) return;
		
		if (evt.getSource() == nameText) {
			model.setName(nameText.getText());
		}
		
		getParent().repaint();
		
	}

}
