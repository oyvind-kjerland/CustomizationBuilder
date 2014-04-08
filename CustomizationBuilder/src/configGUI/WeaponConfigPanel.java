package configGUI;

import java.awt.Dimension;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import config.Config;
import config.WeaponConfig;

public class WeaponConfigPanel extends JPanel {

	WeaponConfigInfoPanel weaponConfigInfoPanel;
	WeaponConfigListPanel weaponConfigListPanel;
	
	public WeaponConfigPanel() {
		weaponConfigInfoPanel = new WeaponConfigInfoPanel();
		weaponConfigListPanel = new WeaponConfigListPanel();
		
		weaponConfigListPanel.setInfoListener(weaponConfigInfoPanel);
		
		add(weaponConfigListPanel);
		add(weaponConfigInfoPanel);
	}
	
	public void setConfig(Config config) {
		weaponConfigListPanel.setConfig(config);
	}
}
