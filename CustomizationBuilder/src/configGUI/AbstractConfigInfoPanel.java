package configGUI;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import config.ConfigInfo;

public abstract class AbstractConfigInfoPanel extends JPanel {

	public AbstractConfigInfoPanel() {
		setPreferredSize(new Dimension(300, 250));
	}
	
	
	public abstract void setModel(ConfigInfo configInfo);
	
	public JLabel makeLabel(String text) {
		JLabel label = new JLabel(text, SwingConstants.LEFT);
		label.setPreferredSize(new Dimension(80,20));
		return label;
	}
	
}
