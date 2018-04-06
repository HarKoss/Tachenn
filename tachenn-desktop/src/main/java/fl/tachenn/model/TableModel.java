package fl.tachenn.model;

public class TableModel {

	private String Name;
	private String[][] rowList;
	private int rowCount;
	private int columnCount;
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String[][] getRowList() {
		return rowList;
	}
	public void setRowList(String[][] rowList) {
		this.rowList = rowList;
	}
	public int getRowCount() {
		return rowCount;
	}
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}
	public int getColumnCount() {
		return columnCount;
	}
	public void setColumnCount(int columnCount) {
		this.columnCount = columnCount;
	}
}
