package configGUI;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import config.Config;
import config.ConfigInfo;
import config.KitConfig;
import config.KitType;
import config.TeamConfig;
import config.WeaponConfig;

public class KitConfigInfoPanel extends AbstractConfigInfoPanel implements ActionListener, FocusListener {
	
	
	private KitConfig model;
	private JTextField kitNameText;
	private JComboBox<KitType> kitTypeComboBox;
	private JList<WeaponConfig> weaponList;
	private DefaultListModel<WeaponConfig> weaponListModel;
	
	private final Dimension infoFieldSize = new Dimension(150,20);
	private final Dimension weaponListSize = new Dimension(150, 100);
	
	public KitConfigInfoPanel() {
		super();
		
		
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(0, 0, 5, 0);
		
		setLayout(layout);
		
		
		// Kit Name
		JLabel kitNameLabel = makeLabel("Name:");
		kitNameText = new JTextField();
		kitNameText.addActionListener(this);
		kitNameText.addFocusListener(this);
		kitNameText.setPreferredSize(infoFieldSize);

		
		// Kit Type
		JLabel kitTypeLabel = makeLabel("Type:");
		kitTypeComboBox = new JComboBox<KitType>(KitType.values());
		kitTypeComboBox.addActionListener(this);
		kitTypeComboBox.setPreferredSize(infoFieldSize);
		
		// Weapons
		JLabel weaponsLabel = makeLabel("Weapons:");
		weaponList = new JList<WeaponConfig>();
		weaponListModel = new DefaultListModel<WeaponConfig>(); 
		weaponList.setModel(weaponListModel);
		JScrollPane weaponListScrollPane = new JScrollPane(weaponList);
		weaponListScrollPane.setPreferredSize(weaponListSize);
		
		
		JButton addWeaponButton = new JButton("Add Weapon");
		addWeaponButton.setPreferredSize(infoFieldSize);
		addWeaponButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showAddWeaponDialog();
			}
		});
		
		
		JButton removeWeaponButton = new JButton("Remove Weapon");
		removeWeaponButton.setPreferredSize(infoFieldSize);
		removeWeaponButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				removeWeapon();
			}
		});
		
		
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
		
		c.gridy = 2;
		c.gridx = 0;
		add(weaponsLabel, c);
		c.gridx = 1;
		add(weaponListScrollPane, c);
		
		c.gridy = 3;
		c.gridx = 1;
		add(addWeaponButton, c);
		c.gridy = 4;
		c.gridx = 1;
		add(removeWeaponButton, c);
		
		
		
	}
	
	
	public void setModel(ConfigInfo configInfo) {
		System.out.println(configInfo);
		if (configInfo == null) {
			model = null;
			kitNameText.setText("");
			kitTypeComboBox.setSelectedItem(KitType.SPECOPS);
			weaponListModel.removeAllElements();
		} else if (configInfo != model) {
			if (model != null) {
				model.setName(kitNameText.getText());
				model.setType((KitType)kitTypeComboBox.getSelectedItem());
			}
			
			model = (KitConfig)configInfo;
			
			kitNameText.setText(model.getName());
			kitTypeComboBox.setSelectedItem(model.getType());
			
			weaponListModel.removeAllElements();
			for (WeaponConfig weaponConfig : model.getWeaponConfigs()) {
				weaponListModel.addElement(weaponConfig);
			}
		}
		
	}

	
	
	
	private void removeWeapon() {
		WeaponConfig weaponConfig = weaponList.getSelectedValue();
		
		if (weaponConfig == null) return;
		
		weaponListModel.removeElement(weaponConfig);
		model.removeWeaponConfig(weaponConfig);
		
	}
	
	private void showAddWeaponDialog() {
		if (model == null) return;
		
		JFrame mainFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
		KitConfigPanel configPanel = (KitConfigPanel)getParent();
		Config config = configPanel.getConfig();
		if (config != null) {
			AddWeaponDialog addWeaponDialog = new AddWeaponDialog(mainFrame, this, config);			
		}
		
	}
	
	public void addWeapon(WeaponConfig weaponConfig) {
		if (weaponListModel.contains(weaponConfig)) return;
		
		weaponListModel.addElement(weaponConfig);
		model.addWeaponConfig(weaponConfig);
	}


	// Lsteners
	@Override
	public void actionPerformed(ActionEvent evt) {
		updateField(evt.getSource());
	}

	@Override
	public void focusGained(FocusEvent arg0) {
	}

	@Override
	public void focusLost(FocusEvent evt) {
		updateField(evt.getSource());
	}
	
	
	private void updateField(Object source) {
		if (model == null) return;
		
		if (source == kitNameText) {
			model.setName(kitNameText.getText());
		} else if (source == kitTypeComboBox) {
			model.setType((KitType)kitTypeComboBox.getSelectedItem());
		}
		
		getParent().repaint();
	}
	
	
}
