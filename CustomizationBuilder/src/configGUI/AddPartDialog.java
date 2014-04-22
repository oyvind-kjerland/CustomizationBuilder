package configGUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.MainFrame;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import config.Config;
import config.PartConfig;
import config.WeaponConfig;

public class AddPartDialog extends JDialog {

	private JList<PartConfig> partList;
	private DefaultListModel<PartConfig> partListModel;
	private GenericPartPanel genericPartPanel;
	
	public AddPartDialog(MainFrame mainFrame, GenericPartPanel genericPartPanel, Config config) {
		super(mainFrame, "Select Part", true);
		
		this.genericPartPanel = genericPartPanel;
		
		
		
		
		JPanel panel = new JPanel();
		
		// WeaponList
		partList = new JList<PartConfig>();
		partListModel = new DefaultListModel<PartConfig>();
		partList.setModel(partListModel);
		
		
		for (PartConfig partConfig : config.getPartConfigs()) {
			if (partConfig.getType() == genericPartPanel.getType()) {
				partListModel.addElement(partConfig);
			}
		}
		
		
		// Add button
		JButton addButton = new JButton("Add");
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				addPart();
			}
		});
		
		JScrollPane scrollPane = new JScrollPane(partList);
		scrollPane.setPreferredSize(new Dimension(150, 200));
		
		setContentPane(panel);
		
		panel.add(scrollPane);
		panel.add(addButton);
		
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		pack();
		setVisible(true);
		
	}
	
	private void addPart() {
		PartConfig partConfig = partList.getSelectedValue();
		if (partConfig != null) {
			genericPartPanel.addPart(partConfig);
			dispose();
		}
	}
		
}
