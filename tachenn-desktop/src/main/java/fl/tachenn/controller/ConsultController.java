package fl.tachenn.controller;

import fl.tachenn.model.DocumentModel;
import fl.tachenn.ui.ConsultPanel;

public class ConsultController {
	
	private ConsultPanel panel;
	private DocumentModel document;

	public ConsultController (ConsultPanel panel, DocumentModel document, TachennController tachennController) {
		this.panel = panel;
		this.document = document;
	}
	
}
