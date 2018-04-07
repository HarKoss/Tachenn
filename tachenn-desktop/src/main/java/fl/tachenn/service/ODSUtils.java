package fl.tachenn.service;

import java.util.ArrayList;
import java.util.List;

import org.odftoolkit.simple.SpreadsheetDocument;
import org.odftoolkit.simple.table.Row;
import org.odftoolkit.simple.table.Table;
import org.springframework.stereotype.Component;

import fl.tachenn.model.DocumentModel;
import fl.tachenn.model.TableModel;

@Component
public class ODSUtils {

	private static final int PREVIEW_TABLE_NUMBER = 5;
	private static final int PREVIEW_ROW_NUMBER = 30;
	private static final int PREVIEW_COLOMN_NUMBER = 40;
	

	public void retriveDocPreview(DocumentModel doc, int nRow, int nColumn) {
		List<TableModel> tablePreviewList = new ArrayList<TableModel>();
		doc.setTableList(tablePreviewList);
		try {
			SpreadsheetDocument ods = SpreadsheetDocument.loadDocument(doc.getFile());
			List<Table> tables = ods.getTableList();
			int tableCount = ods.getTableList().size();
			tableCount = tableCount > PREVIEW_TABLE_NUMBER ? PREVIEW_TABLE_NUMBER : tableCount;
			doc.setTableCount(tableCount);
			for(int i=0; i<tableCount; i++) {
				tablePreviewList.add(retrieveTablePreview(tables.get(i)));
			}
		} catch (Exception e) {
			// TODO use logback
			e.printStackTrace();
		}
	}
	
	private TableModel retrieveTablePreview(Table table) {
		// count rows
		final int rowCount = table.getRowCount() > PREVIEW_ROW_NUMBER ? PREVIEW_ROW_NUMBER : table.getRowCount(); 
		
		// create model
		TableModel tableModel = new TableModel();
		tableModel.setName(table.getTableName());
		tableModel.setRowCount(rowCount);
		tableModel.setColumnCount(PREVIEW_COLOMN_NUMBER);
		
		// fill model
		final String[][] rowList = new String[rowCount][PREVIEW_COLOMN_NUMBER];
		for(int i=0; i<rowCount; i++) {
			rowList[i] = retrieveRowPreview(table.getRowByIndex(i));
		}
		tableModel.setRowList(rowList);
		return tableModel;
	}

	private String[] retrieveRowPreview(Row row) {
		final int cellCount = row.getCellCount();
		String[] rowPreview = new String[PREVIEW_COLOMN_NUMBER];
		for (int cellIndex=0; cellIndex<PREVIEW_COLOMN_NUMBER; cellIndex++) {
			if (cellIndex < cellCount) {
				rowPreview[cellIndex] = row.getCellByIndex(cellIndex).getDisplayText();
			} else{
				rowPreview[cellIndex] = "";
			}
		}
		System.out.println(rowPreview.toString());
		return rowPreview;
	}
}
