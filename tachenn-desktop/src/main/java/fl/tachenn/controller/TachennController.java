package fl.tachenn.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import fl.tachenn.model.DocumentModel;
import fl.tachenn.ui.TachennFrame;

@Component
public class TachennController {
	
	@Resource(name="tachennFrame")
	private TachennFrame tachennFrame;
	
	@Resource(name="consultController")
	private ConsultController consultController;
	
	@Resource(name="startMenuController")
	private StartMenuController startMenuController;
	
	public void init() {
		tachennFrame.init();
		this.openStartMenuPerspective();
	}

	public void openStartMenuPerspective() {
		startMenuController.init();
		tachennFrame.showStartMenu();
	}

	public void openConsultPerspective(DocumentModel doc) {
		consultController.init(doc);
		tachennFrame.showConsultPanel();
	}
}
