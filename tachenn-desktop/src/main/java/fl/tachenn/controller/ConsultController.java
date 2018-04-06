package fl.tachenn.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import fl.tachenn.model.DocumentModel;
import fl.tachenn.service.ODSUtils;
import fl.tachenn.ui.ConsultPanel;
import fl.tachenn.worker.PreviewWorker;

@Component
public class ConsultController {

	@Resource(name="ODSUtils")
	private ODSUtils oDSUtils;
	
	@Resource(name="consultPanel")
	private ConsultPanel panel;
	
	private DocumentModel document;
	
	public void init(DocumentModel doc) {
		panel.init();
		document = doc;	
		launchWorker();
	}
	
	private void launchWorker() {
		//oDSUtils.retriveDocPreview(document, 10, 10);
		// replaced by 
		PreviewWorker worker = new PreviewWorker(document) {
			@Override
			protected void done(){
				// Executed in EDT when work is done
				//panel.addTable();
			}
		};
		/* // To listen the setProgress(int) from doInBackground()
		PropertyChangeListener listener = new PropertyChangeListener(){
			public void propertyChange(PropertyChangeEvent event) {
				if ("progress".equals(event.getPropertyName())) {
					progressBar.setValue( (Integer)event.getNewValue() );
				}
			}
		}; 
		worker.addPropertyChangeListener(listener); */
		worker.execute();
	}
	
}
