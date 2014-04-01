package configGUI;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import config.Config;

public class GeneralConfigPanel extends JPanel {

	private Config model;
	
	private JLabel nameLabel;
	private JTextField nameText;
	
	public GeneralConfigPanel() {
		nameLabel = new JLabel("Config name: ");
		nameText = new JTextField();
		
		
		
		add(nameLabel);
		add(nameText);
	
	}
	
	
	public GeneralConfigPanel(Config model) {
		this();
		setModel(model);
	}
	
	
	public Config getModel() {
		return model;
	}
	
	public void setModel(Config model) {
		this.model = model;
		
	}
	
	
}
