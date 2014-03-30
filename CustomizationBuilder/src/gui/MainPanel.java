package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

import builder.CustomizationBuilder;

public class MainPanel extends GenericPanel {

	
	public MainPanel(CustomizationBuilder customizationBuilder, MainFrame mainFrame) {
		super(customizationBuilder, mainFrame);
		
		JButton selectConfigButton = new JButton("Select Config");
		selectConfigButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectConfig();
			}
		});
		add(selectConfigButton);
		
		JButton editConfigButton = new JButton("Edit Config");
		editConfigButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				showConfigPanel();	
			}
		});
		add(editConfigButton);
		
	}
	
	
	private void selectConfig() {		
		JFileChooser fc = new JFileChooser();
		fc.showOpenDialog(mainFrame);
	}
	
	private void showConfigPanel() {
		mainFrame.showConfigPanel();
	}
}
