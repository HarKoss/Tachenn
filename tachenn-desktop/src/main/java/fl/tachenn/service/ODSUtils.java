package fl.tachenn.service;

import java.util.Iterator;
import java.util.List;

import org.odftoolkit.simple.SpreadsheetDocument;
import org.odftoolkit.simple.table.Row;
import org.odftoolkit.simple.table.Table;
import org.springframework.stereotype.Component;

import fl.tachenn.model.DocumentModel;

@Component
public class ODSUtils {

	public void getDocPreview(DocumentModel doc, int nRow, int nColumn) {
		try {
			SpreadsheetDocument ods = SpreadsheetDocument.loadDocument(doc.getFile());
			List<Table> tables = ods.getTableList();
			for(Table table : tables) {
				Iterator<Row> i = table.getRowIterator();
				while (i.hasNext()) {
					Row row = i.next();
					for (int j=0; j<row.getCellCount(); j++) {
						System.out.println(new StringBuilder("1;").append(row.getCellByIndex(j).getDisplayText()).append(";"));
					}
				}
			}
		} catch (Exception e) {
			// TODO use logback
			e.printStackTrace();
		}
	}
	
}
