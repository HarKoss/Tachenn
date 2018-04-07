package fl.tachenn.controller;

import java.io.File;

import javax.annotation.Resource;
import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.springframework.stereotype.Component;

import fl.tachenn.model.DocumentModel;
import fl.tachenn.ui.StartMenuPanel;

@Component
public class StartMenuController {

	@Resource(name="startMenuPanel")
	private StartMenuPanel startMenuPanel;
	
	@Resource(name="tachennController")
	private TachennController tachennController;

	public void init() {
		startMenuPanel.init();
		startMenuPanel.getOpenFileButton().addActionListener(i -> showOpenDialogue());
		startMenuPanel.getOtherButton().addActionListener(i -> showOtherThing());
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
	        doc.setFile(file);
	        openConsultPanel(doc);
        }
	}
	
	private void showOtherThing() {
		//TODO remove testing code
		/*File file = new File("ODF_TEST.ods");
		DocumentModel doc = new DocumentModel();
        doc.setName(file.getName());
        doc.setAbsolutePath(file.getAbsolutePath());
        doc.setFile(file);
        openConsultPanel(doc);*/
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
