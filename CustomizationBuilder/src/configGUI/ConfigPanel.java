package configGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

import builder.CustomizationBuilder;
import gui.GenericPanel;
import gui.MainFrame;

public class ConfigPanel extends GenericPanel {

	public ConfigPanel(CustomizationBuilder customizationBuilder, MainFrame mainFrame) {
		super(customizationBuilder, mainFrame);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showMainPanel();
			}
		});
		//add(backButton);
		
		JTabbedPane tabbedPane = new JTabbedPane();
		add(tabbedPane);
		tabbedPane.addTab("BackTab", backButton);
		tabbedPane.addTab("Test", new JLabel("Heh this is some pretty long label."));
	}
	
	private void showMainPanel() {
		mainFrame.showMainPanel();
	}

}
