package fl.tachenn.ui;

import javax.swing.JTable;

public class PreviewTable extends JTable {

	private static final long serialVersionUID = 6170261999700304617L;

	public PreviewTable(String[][] rowData, String[] columnNames) {
		super(rowData, columnNames);
	}

	@Override
    public boolean isCellEditable(int row, int column) {
       return false;
    }
    
}
