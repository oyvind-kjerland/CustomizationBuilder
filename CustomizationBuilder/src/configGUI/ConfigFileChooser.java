package configGUI;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class ConfigFileChooser extends JFileChooser {

	@Override
	public void approveSelection() {
		if (getDialogType() == SAVE_DIALOG) {
			File selectedFile = getSelectedFile();
			if ((selectedFile != null) && selectedFile.exists()) {
				int response = JOptionPane.showConfirmDialog(this, 
					"" + selectedFile.getName() + " already exists. Do you want to replace the existing file?",
					"Overwrite file", JOptionPane.YES_NO_OPTION,
					JOptionPane.WARNING_MESSAGE);
				if (response != JOptionPane.YES_OPTION) {
					return;
				}
			}
		}
		super.approveSelection();
	}
	
}
