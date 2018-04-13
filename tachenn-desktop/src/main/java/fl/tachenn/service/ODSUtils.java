package fl.tachenn.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.odftoolkit.simple.SpreadsheetDocument;
import org.odftoolkit.simple.table.Row;
import org.odftoolkit.simple.table.Table;
import org.springframework.stereotype.Component;

import fl.tachenn.model.DocumentModel;
import fl.tachenn.model.TableModel;

@Component
public class ODSUtils {

	private static final int PREVIEW_TABLE_NUMBER = 3;
	private static final int PREVIEW_ROW_NUMBER = 30;
	private static final int PREVIEW_COLOMN_NUMBER = 42;
	
	private int cellNumber = 0;
	

	public void retriveDocPreview(DocumentModel doc) {
		if(doc.getTableList() == null){
			retriveDocumentDescription(doc);
		}
		Map<String, TableModel> tablePreviewMap = doc.getTableList();
		try {
			SpreadsheetDocument ods = SpreadsheetDocument.loadDocument(doc.getFile());
			List<Table> tables = ods.getTableList();
			int tableCount = ods.getTableList().size();
			tableCount = tableCount > PREVIEW_TABLE_NUMBER ? PREVIEW_TABLE_NUMBER : tableCount;
			doc.setTableCount(tableCount);
			for(int i=0; i<tableCount; i++) {
				tablePreviewMap.get(tables.get(i).getTableName()).setRowList(retrieveTablePreview(tables.get(i)));;
			}
		} catch (Exception e) {
			// TODO use logback
			e.printStackTrace();
		}
	}
	
	private String[][] retrieveTablePreview(Table table) {
		// count rows
		final int rowCount = table.getRowCount() > PREVIEW_ROW_NUMBER ? PREVIEW_ROW_NUMBER : table.getRowCount();
		
		// fill model
		final String[][] rowList = new String[rowCount][PREVIEW_COLOMN_NUMBER];
		for(int i=0; i<rowCount; i++) {
			rowList[i] = retrieveRowPreview(table.getRowByIndex(i));
		}
		return rowList;
	}

	private String[] retrieveRowPreview(Row row) {
		final int cellCount = row.getCellCount();
		String[] rowPreview = new String[PREVIEW_COLOMN_NUMBER];
		for (int cellIndex=0; cellIndex<PREVIEW_COLOMN_NUMBER; cellIndex++) {
			cellNumber++;
			if (cellIndex < cellCount) {
				rowPreview[cellIndex] = row.getCellByIndex(cellIndex).getDisplayText();
			} else {
				rowPreview[cellIndex] = "";
			}
		}
		return rowPreview;
	}

	public void retriveDocumentDescription(DocumentModel document) {
		Map<String, TableModel> tableMap = new HashMap<String, TableModel>();
		document.setTableList(tableMap);
		try {
			SpreadsheetDocument ods = SpreadsheetDocument.loadDocument(document.getFile());
			List<Table> tables = ods.getTableList();
			int tableCount = ods.getTableList().size();
			tableCount = tableCount > PREVIEW_TABLE_NUMBER ? PREVIEW_TABLE_NUMBER : tableCount;
			document.setTableCount(tableCount);
			for(int i=0; i<tableCount; i++) {
				tableMap.put(tables.get(i).getTableName(), retrieveTableDescription(tables.get(i)));
			}
		} catch (Exception e) {
			// TODO use logback
			e.printStackTrace();
		}
	}

	private TableModel retrieveTableDescription(Table table) {
		// count rows
		final int rowCount = table.getRowCount() > PREVIEW_ROW_NUMBER ? PREVIEW_ROW_NUMBER : table.getRowCount();
		
		// create model
		TableModel tableModel = new TableModel();
		tableModel.setName(table.getTableName());
		tableModel.setRowCount(rowCount);
		tableModel.setColumnCount(PREVIEW_COLOMN_NUMBER);
		
		// fill header
		final String[] headerList = new String[PREVIEW_COLOMN_NUMBER];
		if(table.getRowCount()>0){
			Row row = table.getRowByIndex(0);
			final int cellCount = row.getCellCount();
			for (int cellIndex=0; cellIndex<PREVIEW_COLOMN_NUMBER; cellIndex++) {
				cellNumber++;
				if (cellIndex < cellCount) {
					headerList[cellIndex] = row.getCellByIndex(cellIndex).getDisplayText();
				} else {
					headerList[cellIndex] = "";
				}
			}
		}
		tableModel.setHeaderList(headerList);
		
		return tableModel;
	}
}
