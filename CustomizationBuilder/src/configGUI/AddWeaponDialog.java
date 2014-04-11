package configGUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import config.Config;
import config.WeaponConfig;

public class AddWeaponDialog extends JDialog {

	
	private JList<WeaponConfig> weaponList;
	private DefaultListModel<WeaponConfig> weaponListModel;
	private KitConfigInfoPanel kitInfoPanel;
	
	
	public AddWeaponDialog(JFrame frame, KitConfigInfoPanel kitInfoPanel, Config config) {
		super(frame, "Select Weapon", true);
		
		this.kitInfoPanel = kitInfoPanel;
		
		JPanel panel = new JPanel();
		
		// WeaponList
		weaponList = new JList<WeaponConfig>();
		weaponListModel = new DefaultListModel<WeaponConfig>();
		weaponList.setModel(weaponListModel);
		//weaponList.setPreferredSize(new Dimension(150, 200));
		
		// Fill weaponList
		for (WeaponConfig weaponConfig : config.getWeaponConfigs()) {
			weaponListModel.addElement(weaponConfig);
		}
		
		// Add button
		JButton addButton = new JButton("Add");
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				addWeapon();
			}
		});
		
		
		
		JScrollPane scrollPane = new JScrollPane(weaponList);
		scrollPane.setPreferredSize(new Dimension(150, 200));
		
		setContentPane(panel);
		
		panel.add(scrollPane);
		panel.add(addButton);		
		
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		pack();
		setVisible(true);
	}
	
	private void addWeapon() {
		WeaponConfig weaponConfig = weaponList.getSelectedValue();
		
		if (weaponConfig == null) return;
		
		kitInfoPanel.addWeapon(weaponConfig);
		dispose();
		
	}
	
	
}
