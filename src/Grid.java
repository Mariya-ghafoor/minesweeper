import java.util.ArrayList;
import java.util.Random;

public class Grid {
	
	int ROWS;
	int COLS;
	ArrayList<ArrayList<String>> GRID;
	
	
	public Grid(int rows, int cols) {
		this.ROWS = rows;
		this.COLS = cols;		
	}
	
	public ArrayList<ArrayList<String>> getGrid() {
		
		//Create a grid of empty spaces and bombs
		ArrayList<ArrayList<String>> grid = new ArrayList<>();
				
		String[] options = new String[]{"#", "#", "💣"};
				
		Random rand = new Random();
				
		for (int i = 0; i < this.ROWS; i++) {
			ArrayList<String> innerList = new ArrayList<>();
					
			for (int j = 0; j < this.COLS; j++) {
				//choose a random string from options list
				innerList.add(options[rand.nextInt(3)]);
				}
			
			//add columns to the row
			grid.add(innerList);
			
			}
		this.GRID = grid;
		
		ArrayList<ArrayList<String>> finalGrid = addNumbersOfBombs();
		
		return finalGrid;
		
	}
	

	private ArrayList<ArrayList<String>> addNumbersOfBombs() {
		
		for(int i=0; i< ROWS; i++) {
			for(int j=0; j< COLS; j++) {
				if(GRID.get(i).get(j) == "#") {
					int totalBombs = calculateNumberOfBombs(i,j);
					//System.out.println("Total bombs around i= "+i+" and j= "+j+" are "+totalBombs);
					GRID.get(i).set(j, Integer.toString(totalBombs));
				}
				
			}

			 }
		
		return GRID;
		
		
	}

	private int calculateNumberOfBombs(int row, int col) {
		int totalBombsAround = 0;
		int start_row; //start checking from previous row;
		int end_row; //stop checking at next row
		
		int start_col;
		int end_col;
		
		if(row - 1 < 0) start_row = row; //if previous row is less than 0 then don't check it
		else start_row = row - 1;
		
		if(row + 1 >= ROWS) end_row = row; //if next row is greater than max no. of rows then don't check it
		else end_row = row + 1;
		
		if(col - 1 < 0) start_col = col;
		else start_col = col - 1;
		
		if(col + 1 >= COLS) end_col = col;
		else end_col = col + 1;
		
		for(int i = start_row; i <= end_row; i++) {
			for(int j = start_col; j <= end_col; j++) {
				
				if(GRID.get(i).get(j) == "💣") {
					totalBombsAround++;
				}
			}
		}	

		return totalBombsAround;
		

	}




//Printing the mine to the console
	public void printGrid(ArrayList<ArrayList<String>> grid) {
		for(int i=0; i< this.ROWS; i++) {
		//printing rows
			System.out.println(grid.get(i).toString());
	}		
}
}
