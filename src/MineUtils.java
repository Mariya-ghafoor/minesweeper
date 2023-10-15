import java.util.ArrayList;

public class MineUtils {
	private ArrayList<ArrayList<String>> grid;
	private ArrayList<ArrayList<String>> hiddenGrid;
	
	public MineUtils(ArrayList<ArrayList<String>> grid) {
		this.setGrid(grid);
		
		
	}
	
	public ArrayList<ArrayList<String>> createHiddenMine(int rows, int cols) {
		
		ArrayList<ArrayList<String>> hiddenGrid = new ArrayList<>();
		
		for (int i = 0; i < rows; i++) {
			ArrayList<String> innerList = new ArrayList<>();
			
		    for (int j = 0; j < cols; j++) {
		    	//populate innerlist with ? to hide
		        innerList.add("?");
		    }
		    //add columns to the row
		    hiddenGrid.add(innerList);
		    
		}
		
		setHiddenGrid(hiddenGrid);
		return hiddenGrid;
		
	}
	
	
	public ArrayList<ArrayList<String>> revealCell(int selected_row, int selected_col, ArrayList<ArrayList<String>> hiddenGrid ) {
		
		String value = getGrid().get(selected_row).get(selected_col);
		
		hiddenGrid.get(selected_row).set(selected_col, value);
		
		
		
		return hiddenGrid;
		
	}
	
	
	
	
	
	
	
	
	

	public ArrayList<ArrayList<String>> getGrid() {
		return grid;
	}

	public void setGrid(ArrayList<ArrayList<String>> grid) {
		this.grid = grid;
	}
	
	public ArrayList<ArrayList<String>> getHiddenGrid() {
		return hiddenGrid;
	}

	public void setHiddenGrid(ArrayList<ArrayList<String>> hiddenGrid) {
		this.hiddenGrid = hiddenGrid;
	}
	
	

	
}
