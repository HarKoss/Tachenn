package fl.tachenn.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import fl.tachenn.model.DocumentModel;
import fl.tachenn.ui.ConsultPanel;

@Component
public class ConsultController {
	
	@Resource(name="consultPanel")
	private ConsultPanel panel;
	
	private DocumentModel document;
	
	public void init(DocumentModel doc) {
		panel.init();
		document = doc;	
	}
	
}
