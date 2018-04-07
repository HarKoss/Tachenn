package fl.tachenn.ui;

import java.awt.GridLayout;

import javax.annotation.Resource;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import fl.tachenn.model.DocumentModel;
import fl.tachenn.model.TableModel;

@org.springframework.stereotype.Component
public class ConsultPanel extends JPanel {

	private static final long serialVersionUID = 2644312129917630605L;
	
	@Resource(name="tachennFrame")
	private TachennFrame tachennFrame;
	
	private JTabbedPane previewTabs;

	public void init(DocumentModel doc) {
		this.setLayout(new GridLayout(1, 1));
		
		previewTabs = new JTabbedPane();
		for(TableModel tableModel : doc.getTableList()) {
			PreviewTable previewTable = new PreviewTable(tableModel.getRowList(), tableModel.getRowList()[0]);
			previewTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			JScrollPane scrollPane = new JScrollPane(previewTable,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			previewTabs.add(tableModel.getName(), scrollPane);
		}
		this.add(previewTabs);
		tachennFrame.revalidate();
	}

}
