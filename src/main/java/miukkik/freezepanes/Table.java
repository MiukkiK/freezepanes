package miukkik.freezepanes;

import java.util.ArrayList;

/**
 * Two-dimensional table of Cells made with ArrayLists.
 * @author Mia Kallio
 */
public class Table {
	
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
	
	public ArrayList<ArrayList<Cell>> getTable() {
		return table;
	}
	
}
