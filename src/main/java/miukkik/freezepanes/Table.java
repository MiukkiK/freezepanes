package miukkik.freezepanes;

import java.util.ArrayList;

/**
 * Two-dimensional table of Cells made with ArrayLists.
 * @author Mia Kallio
 */
public class Table implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private ArrayList<ArrayList<Cell>> table;
	
	public Table() {
		table = new ArrayList<ArrayList<Cell>>();
	}

	public void addRow(String...strings) {
		ArrayList<Cell> row = new ArrayList<Cell>();
		for (String string : strings) {
			row.add(new Cell(string));
		}
		table.add(row);
	}
	
	public Cell get(int row, int column) {
		return table.get(row).get(column);
	}
	
	public int getHeight() {
		return table.size();
	}
	
	public int getWidth() {
		// refactor if different amount of rows allowed
		return table.get(0).size();
	}
}