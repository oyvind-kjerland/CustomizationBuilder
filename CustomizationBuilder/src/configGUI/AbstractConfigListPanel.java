package configGUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import config.Config;

public abstract class AbstractConfigListPanel<T> extends JPanel {

	
	protected JList<T> configList;
	protected DefaultListModel<T> configListModel;
	protected Config config;
	protected ConfigInfoPanel infoListener;
	
	public AbstractConfigListPanel() {
		
		// Set size
		setPreferredSize(new Dimension(200, 250));
		
		
		configList = new JList<T>();
		configListModel = new DefaultListModel<T>();
		configList.setModel(configListModel);
		configList.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				selectConfig();
			}
		});
		
		
		JScrollPane scrollPane = new JScrollPane(configList);
		scrollPane.setPreferredSize(new Dimension(200, 200));
		
		JButton newButton = new JButton("New");
		newButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				newConfig();
			}
		});
		JButton deleteButton = new JButton("Delete");
		deleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteConfig();
			}
		});
		
		add(scrollPane);
		add(newButton);
		add(deleteButton);
	}
	
	
	public void setInfoListener(ConfigInfoPanel configInfoPanel) {
		infoListener = configInfoPanel;
	}
	
	public void removeInfoListener() {
		infoListener = null;
	}
	
	public abstract void setConfig(Config config);
	
	protected abstract void selectConfig();
	
	protected abstract void newConfig();
	
	protected abstract void deleteConfig();
	
	
	
}
