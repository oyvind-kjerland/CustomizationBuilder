package configGUI;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import config.ConfigInfo;

public abstract class AbstractConfigInfoPanel extends JPanel {

	public abstract void setModel(ConfigInfo configInfo);
	
	public JLabel makeLabel(String text) {
		JLabel label = new JLabel(text, SwingConstants.LEFT);
		label.setPreferredSize(new Dimension(50,20));
		return label;
	}
	
}
