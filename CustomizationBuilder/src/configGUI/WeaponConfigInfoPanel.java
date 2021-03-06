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
import javax.swing.JPanel;
import javax.swing.JTextField;

import config.ConfigInfo;
import config.PartType;
import config.WeaponConfig;

public class WeaponConfigInfoPanel extends AbstractConfigInfoPanel implements ActionListener, FocusListener {

	
	private WeaponConfig model;
	
	private JTextField nameText;
	
	private GenericPartPanel sightPanel;
	private GenericPartPanel attachmentPanel;
	private GenericPartPanel skinPanel;
	
	private final Dimension infoFieldSize = new Dimension(150,20);
	
	public WeaponConfigInfoPanel() {
		super();
		
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(0, 0, 0, 0);
		setLayout(layout);
		
		// Labels
		JLabel nameLabel = makeLabel("Name:");
		nameText = new JTextField();
		nameText.addActionListener(this);
		nameText.addFocusListener(this);
		nameText.setPreferredSize(infoFieldSize);
		
		
		
		JLabel sightLabel = makeLabel("Sight");
		sightPanel = new GenericPartPanel(PartType.SIGHT);

		JLabel attachmentLabel = makeLabel("Attachment:");
		attachmentPanel = new GenericPartPanel(PartType.ATTACHMENT);
		
		JLabel skinLabel = makeLabel("Skin:");
		skinPanel = new GenericPartPanel(PartType.SKIN);
		
		
		c.gridy = 0;
		c.gridx = 0;
		add(nameLabel, c);
		c.gridx = 1;
		add(nameText, c);
		
		c.gridy = 1;
		c.gridx = 0;
		add(sightLabel, c);
		c.gridx = 1;
		add(sightPanel, c);
		
		c.gridy = 2;
		c.gridx = 0;
		add(attachmentLabel, c);
		c.gridx = 1;
		add(attachmentPanel, c);
		
		c.gridy = 3;
		c.gridx = 0;
		add(skinLabel, c);
		c.gridx = 1;
		add(skinPanel, c);
	}

	
	@Override
	public void setModel(ConfigInfo configInfo) {
		if (configInfo == null) {
			nameText.setText("");
			sightPanel.setModel(null);
		} else if (configInfo != model) {			
			if (model != null) {
				// Save values before the new model is set
				model.setName(nameText.getText());
			}
			
			model = (WeaponConfig)configInfo;
			
			nameText.setText(model.getName());
			
			sightPanel.setModel(model);
			attachmentPanel.setModel(model);
			skinPanel.setModel(model);
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
