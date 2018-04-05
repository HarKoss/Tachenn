package fl.tachenn.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import fl.tachenn.model.DocumentModel;
import fl.tachenn.service.ODSUtils;
import fl.tachenn.ui.TachennFrame;

@Component
public class TachennController {
	
	@Resource(name="tachennFrame")
	private TachennFrame tachennFrame;
	
	@Resource(name="consultController")
	private ConsultController consultController;
	
	@Resource(name="startMenuController")
	private StartMenuController startMenuController;

	@Resource(name="ODSUtils")
	private ODSUtils oDSUtils;
	
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
		oDSUtils.getDocPreview(doc, 10, 10);
		tachennFrame.showConsultPanel();
	}
}
