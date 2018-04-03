package fl.tachenn.controller;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.springframework.beans.factory.annotation.Autowired;

import fl.tachenn.model.DocumentModel;
import fl.tachenn.ui.StartMenuPanel;

public class StartMenuController {
	
	StartMenuPanel startMenuPanel;
	JPanel previousPanel;
	
	TachennController tachennController;

	public StartMenuController(StartMenuPanel panel, TachennController tachennController) {
		startMenuPanel = panel;
		this.tachennController = tachennController;
		initListenner();
	}
	
	private void initListenner() {
		startMenuPanel.getOpenFileButton().addActionListener(i -> showOpenDialogue());
	}

	private void showOpenDialogue() {
        JFileChooser openFile = new JFileChooser();
        FileFilter filter = new FileNameExtensionFilter("Classeur ODF (*.ods)", "ods");
        openFile.addChoosableFileFilter(filter);
        int returned = openFile.showOpenDialog(null);
        if(returned == JFileChooser.APPROVE_OPTION) {
	        File file = openFile.getSelectedFile();
	        System.out.println("Path to the file - " + file.getAbsolutePath());
	        System.out.println(tachennController);
	        DocumentModel doc = new DocumentModel();
	        doc.setName(file.getName());
	        doc.setAbsolutePath(file.getAbsolutePath());
	        doc.setFile(openFile.getCurrentDirectory());
	        openConsultPanel(doc);
        }
	}
	
	public void openConsultPanel(DocumentModel doc) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				tachennController.openConsultPerspective(doc);
			}
		});
	}
}
