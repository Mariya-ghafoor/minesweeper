import java.util.ArrayList;
import java.util.Random;

public class Mine {
	private int ROWS;
	private int COLS;
	private ArrayList<ArrayList<String>> MINE;
	
	public Mine(int ROWS, int COLS) {
		this.setROWS(ROWS);
		this.setCOLS(COLS);	
	}
	
	//Creating a mine from provided rows and columns
	
	public ArrayList<ArrayList<String>> createMine(){
ArrayList<ArrayList<String>> grid = new ArrayList<>();
		
		String[] options = new String[]{"#", "#", "*"};
		
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
		this.setMINE(grid);
		
		addNumbersInMine();
		
		return grid;
		
	}
	

	
	
	//Replacing empty spaces with numbers
	private void addNumbersInMine(){
		for(int i=0; i< getROWS(); i++) {
			for(int j=0; j< getCOLS(); j++) {
				if(MINE.get(i).get(j) == "#") {
					int totalBombs = calculateNumberOfBombs(i,j);
					//System.out.println("Total bombs around i= "+i+" and j= "+j+" are "+totalBombs);
					MINE.get(i).set(j, Integer.toString(totalBombs));
				}
				
			}

			 }
			}
		
		
	
	
	private int calculateNumberOfBombs(int row, int col) {
		
		int totalBombsAround = 0;
		int start_row; //start checking from previous row;
		int end_row; //stop checking at next row
		
		int start_col;
		int end_col;
		
		if(row - 1 < 0) start_row = row; //if previous row is less than 0 then don't check it
		else start_row = row - 1;
		
		if(row + 1 >= getROWS()) end_row = row; //if next row is greater than max no. of rows then don't check it
		else end_row = row + 1;
		
		if(col - 1 < 0) start_col = col;
		else start_col = col - 1;
		
		if(col + 1 >= getCOLS()) end_col = col;
		else end_col = col + 1;
		
		for(int i = start_row; i <= end_row; i++) {
			for(int j = start_col; j <= end_col; j++) {
				
				if(getMINE().get(i).get(j) == "*") {
					totalBombsAround++;
				}
			}
		}	

		return totalBombsAround;
		
	}

//Printing the mine to the console
	public void printMine(ArrayList<ArrayList<String>> mine) {
		for(int i=0; i< this.ROWS; i++) {
		//printing rows
			System.out.println(mine.get(i).toString());
	}		
}
	
	

	public int getROWS() {
		return ROWS;
	}

	public void setROWS(int rOWS) {
		ROWS = rOWS;
	}

	public int getCOLS() {
		return COLS;
	}

	public void setCOLS(int cOLS) {
		COLS = cOLS;
	}

	public ArrayList<ArrayList<String>> getMINE() {
		return MINE;
	}

	public void setMINE(ArrayList<ArrayList<String>> mINE) {
		MINE = mINE;
	}

}
