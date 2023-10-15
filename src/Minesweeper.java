import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;
import java.awt.event.*;

public class Minesweeper {
	private static final long serialVersionUID = 1L;

	private class MineTile extends JButton {
		private static final long serialVersionUID = 1L;
		int r;
		int c;
		
		public MineTile(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	
	
	int tileSize = 70;
	int rows = 10;
	int cols = 10;
	int boardWidth = tileSize * rows;
	int boardHeight = tileSize * cols;
	
	JFrame frame = new JFrame("Minesweeper");
	JLabel textLabel = new JLabel();
	JPanel textPanel = new JPanel();
	JPanel boardPanel = new JPanel();
	
	MineTile[][] board = new MineTile[rows][cols];
	
	
	
	
	public Minesweeper() {
		
		//Create a grid
		Grid myGrid = new Grid(this.rows, this.cols);
		ArrayList<ArrayList<String>> grid = myGrid.getGrid();
		System.out.println("Grid created:");
		myGrid.printGrid(grid);
		
		
		
		frame.setSize(boardWidth,boardHeight);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		
		textLabel.setFont(new Font("Arial", Font.BOLD, 25));
		textLabel.setHorizontalAlignment(JLabel.CENTER);
		textLabel.setText("Minesweeper");
		textLabel.setOpaque(true);
		
		textPanel.setLayout(new BorderLayout());
		textPanel.add(textLabel);
		frame.add(textPanel, BorderLayout.NORTH);
		
		boardPanel.setLayout(new GridLayout(rows, cols));
		//boardPanel.setBackground(Color.green);
		frame.add(boardPanel);
		

		
//		Filling grid with tiles
		for(int r=0; r < rows; r++) {
			for(int c=0; c < cols; c++) {
				//System.out.println("row= "+r+" col= "+c);
				MineTile tile = new MineTile(r,c);
				board[r][c] = tile;
				tile.setFocusable(false);
				tile.setMargin(new Insets(0,0,0,0));
				tile.setFont(new Font("Arial Unicode MS", Font.PLAIN, 45));
				
				tile.addMouseListener(new MouseAdapter(){
					@Override
					public void mousePressed(MouseEvent e) {
						if(tile.getText()=="") {
							System.out.println("Empty tile clicked at row= "+tile.r+" and col= "+tile.c);
							tile.setEnabled(false);
							String valueInGrid = grid.get(tile.r).get(tile.c);
							if(valueInGrid == "💣") {
								tile.setText("💣");
								revealGrid();}
							else tile.setText(valueInGrid);	
						}
					}

		private void revealGrid() {
			System.out.println("i m revealing grid");
			textLabel.setText("Game Over!");
			for(int r=0; r<rows; r++) {
				for(int c=0; c<cols; c++) {
					MineTile tile = board[r][c];
					String valueInGrid = grid.get(r).get(c);
					tile.setText(valueInGrid);
					tile.setEnabled(false);
					
				}
				}
			}
					
				});
				
				
				
				
				boardPanel.add(tile);
				
				
			}
		}
		frame.setVisible(true);
		
	}

}
