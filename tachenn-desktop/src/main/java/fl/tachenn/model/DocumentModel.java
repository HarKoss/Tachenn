package fl.tachenn.model;

import java.io.File;
import java.util.Map;

public class DocumentModel {

	private String Name;
	private String absolutePath;
	private File file;
	private Map<String, TableModel> tableMap;
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
	public Map<String, TableModel> getTableList() {
		return tableMap;
	}
	public void setTableList(Map<String, TableModel> tableList) {
		this.tableMap = tableList;
	}
	public int getTableCount() {
		return tableCount;
	}
	public void setTableCount(int tableCount) {
		this.tableCount = tableCount;
	}
}
