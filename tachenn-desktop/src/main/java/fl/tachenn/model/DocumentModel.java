package fl.tachenn.model;

import java.io.File;
import java.util.List;

public class DocumentModel {

	private String Name;
	private String absolutePath;
	private File file;
	private List<TableModel> tableList;
	private int tableCount;
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAbsolutePath() {
		return absolutePath;
	}
	public void setAbsolutePath(String absolutePath) {
		this.absolutePath = absolutePath;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public List<TableModel> getTableList() {
		return tableList;
	}
	public void setTableList(List<TableModel> tableList) {
		this.tableList = tableList;
	}
	public int getTableCount() {
		return tableCount;
	}
	public void setTableCount(int tableCount) {
		this.tableCount = tableCount;
	}
}
