package fl.tachenn.worker;

import javax.annotation.Resource;
import javax.swing.SwingWorker;

import fl.tachenn.model.DocumentModel;
import fl.tachenn.service.ODSUtils;

public class PreviewWorker extends SwingWorker<Integer, String> {

	@Resource(name="ODSUtils")
	private ODSUtils oDSUtils = new ODSUtils();
	
	private DocumentModel document;
	
	public PreviewWorker(DocumentModel document) {
		super();
		this.document = document;
	}
	
	@Override
	protected Integer doInBackground() throws Exception {
		oDSUtils.retriveDocumentDescription(document);
		oDSUtils.retriveDocPreview(document);
		
	 	// could add setProgress(int progress) wich can be read from panel with addPropertyChangeListener(PropertyChangeListener listener)
		// publish(String) could be retrieved as chunk from process(List<String> chunks)
		
		return null;
	}
	
/*
	@Override
	protected void process(List<String> chunks){
		for(String message : chunks){
			// use publish(String) in doInBackground() to retrieve it as chunk
			// you can interact with ui here, it will be executed in EDT
		}
	}
*/
}
