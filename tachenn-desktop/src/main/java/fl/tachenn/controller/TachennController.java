package fl.tachenn.controller;

import javax.swing.JPanel;

import fl.tachenn.model.DocumentModel;
import fl.tachenn.ui.ConsultPanel;
import fl.tachenn.ui.StartMenuPanel;
import fl.tachenn.ui.TachennFrame;

public class TachennController {
	
	private TachennFrame tachennFrame;
	private JPanel currentPanel;

	public TachennController(TachennFrame frame) {
		tachennFrame = frame;
		tachennFrame.init();
	}

	public void openStartMenuPerspective() {
		StartMenuPanel menuPanel = new StartMenuPanel();
		StartMenuController menuController = new StartMenuController(menuPanel, this);
		reloadPanel(menuPanel);
	}

	public void openConsultPerspective(DocumentModel doc) {
		ConsultPanel consultPanel = new ConsultPanel();
		ConsultController consultController = new ConsultController(consultPanel, doc, this);
		reloadPanel(consultPanel);
	}
	
	private void reloadPanel(JPanel newPanel) {
		if (currentPanel != null) {
			tachennFrame.remove(currentPanel);
		}
		currentPanel = newPanel;
		tachennFrame.add(newPanel);
	}
}
