package configGUI;

import gui.MainFrame;

import java.awt.Dimension;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import config.Config;
import config.PartConfig;
import config.PartType;
import config.WeaponConfig;

public class GenericPartPanel extends JPanel {

	
	private WeaponConfig model;
	
	private JList<PartConfig> list;
	private DefaultListModel<PartConfig> listModel;
	
	
	private PartType type;
	
	public GenericPartPanel(PartType type) {
		
		this.type = type;
		
		list = new JList<PartConfig>();
		listModel = new DefaultListModel<PartConfig>();
		list.setModel(listModel);
		
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setPreferredSize(new Dimension(90, 60));
		
		add(scrollPane);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setPreferredSize(new Dimension(55, 60));
		
		JButton addButton = new JButton("Add");
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				showAddDialog();
			}
		});
		buttonPanel.add(addButton);
		
		JButton removeButton = new JButton("Rem");
		removeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				removePart();
			}
		});
		buttonPanel.add(removeButton);
		
		add(buttonPanel);
		
	}
	
	
	public void setModel(WeaponConfig model) {
		this.model = model;
		
		if (model == null) return;
		
		// Fill list
		listModel.removeAllElements();
		for (PartConfig partConfig : model.getPartsOfType(this.type)) {
			listModel.addElement(partConfig);
		}
	}
	
	public void showAddDialog() {
		if (model == null) return;
		
		MainFrame mainFrame = (MainFrame)SwingUtilities.getWindowAncestor(this);
		ConfigPanel configPanel = (ConfigPanel)getParent().getParent().getParent().getParent();
		Config config = configPanel.getConfig();
		AddPartDialog dialog = new AddPartDialog(mainFrame, this, config);
		
	}

	
	public void addPart(PartConfig partConfig) {
		if (listModel.contains(partConfig)) return;
		
		listModel.addElement(partConfig);
		model.addPartConfig(partConfig);
		
	}
	
	
	public void removePart() {
		if (model == null) return;
		
		PartConfig partConfig = list.getSelectedValue();
		listModel.removeElement(partConfig);
		model.removePartConfig(partConfig);
	}
	
	public PartType getType() {
		return type;
	}
	
}
