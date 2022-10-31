public class Board{
	private String[][] HitOrmiss;
	private Space[][] grid;
	/** Default Constructor puts corresponding coordinate into grid */
	Board() {
	  grid = new Space[10][10];
	  for(int i=0;i<10;i++){
		for(int j=0;j<10;j++){
		  Coordinate c = new Coordinate(i,j);
		  grid[i][j] = new Space(c);
		}
	  }
	}
  
	
  public Space getSpace(int x, int y){
	  return grid[x][y];
  }
  
	public Space[][] getGrid(){
		return grid;
	}
	
	
	/**
	 * Prolly make it so each Space has a square to display instead of doing this
	 * 
	 */
	public String[][] displayBoard() {
		String [][] updateBoard = new String[10][10];
		System.out.println("BOARD:");
		StringBuilder sb = new StringBuilder();
		char c = 'A';
  
		System.out.print(" ");
		for (int i = 0 ; i < 10; i++)
		{
			  System.out.print(" " + i );
		}
		System.out.println("");
		for (int j = 0; j < 10; j++)
		{
		  System.out.print(c++);
			for (int i = 0; i < 10; i++)
			{
			  //System.out.print("grid " + i + " " + j + " " + grid[i][j].isShipHere());
			  if (grid[i][j].isShipHere() == true) {
			  updateBoard[i][j]= " $";
			  System.out.print(updateBoard[i][j]);
			  } else {
			  updateBoard[i][j]= " *";
			  System.out.print(updateBoard[i][j]);
			  }
			}
			System.out.println("");
		}
		return updateBoard;
	}	

	public String[][] displayBoardPlaceShips() {
		String [][] updateBoard = new String[10][10];
		System.out.println("BOARD:");
		StringBuilder sb = new StringBuilder();
		int num = 0;
  
		System.out.print(" ");
		for (int i = 0 ; i < 10; i++)
		{
			  System.out.print(" " + i );
		}
		System.out.println("");
		for (int j = 0; j < 10; j++)
		{
		  System.out.print(num++);
			for (int i = 0; i < 10; i++)
			{
			  //System.out.print("grid " + i + " " + j + " " + grid[i][j].isShipHere());
			  if (grid[i][j].isShipHere() == true) {
			  updateBoard[i][j]= " $";
			  System.out.print(updateBoard[i][j]);
			  } else {
			  updateBoard[i][j]= " *";
			  System.out.print(updateBoard[i][j]);
			  }
			}
			System.out.println("");
		}
		return updateBoard;
	}	
  
	public String[][] displayBoard(String board[][], String x, String y) {
	  System.out.println("BOARD:");
	  StringBuilder sb = new StringBuilder();
	  char c = 'A';
	  char conversion = x.charAt(0);
	  int count = 1;
	  int rowIndex = 0;
	  if ((conversion == 'A') || (conversion == 'A'))
		  {
			  rowIndex = 0;
		  } else if ((conversion == 'b') || (conversion == 'B'))
		  {
			  rowIndex = 1;
		  } else if ((conversion == 'C') || (conversion == 'c'))
		  {
			  rowIndex = 2;
		  } else if ((conversion == 'D') || (conversion == 'd') )
		  {
			  rowIndex = 3;
		  } else if ((conversion == 'E') || (conversion == 'e'))
		  {
			  rowIndex = 4;
		  } else if ((conversion == 'F') || (conversion == 'f'))
		  {
			  rowIndex = 5;
		  } else if ((conversion == 'G') || (conversion == 'g'))
		  {
			  rowIndex = 6;
		  } else if ((conversion == 'H') || (conversion == 'h'))
		  {
			  rowIndex = 7;
		  } else if ((conversion == 'I') || (conversion == 'i'))
		  {
			  rowIndex = 8;
		  } else
		  {
			  rowIndex = 9;
		  }
	  int columnIndex = Integer.parseInt(y);
	  System.out.print(" ");
	  for (int i = 0 ; i < 10; i++)
	  {
			System.out.print(" " + i );
	  }
	  System.out.println("");
	  for (int j = 0; j < 10; j++)
	  {
		System.out.print(c++);
		  for (int i = 0; i < 10; i++)
		  {
			if (board[columnIndex][rowIndex] == " $") {
			board[columnIndex][rowIndex] = " X";
			count--;
			System.out.print(board[i][j]);
			} else {
			System.out.print(board[i][j]);
			}
		  }
		  System.out.println("");
	  }
	  return board;
  }
  
  public String[][] HitOrMissBoard()
  {
	  String [][] updateBoard = new String[10][10];
		System.out.println("HIT AND MISS BOARD:");
		StringBuilder sb = new StringBuilder();
		char c = 'A';
  
		System.out.print(" ");
		for (int i = 0 ; i < 10; i++)
		{
			  System.out.print(" " + i );
		}
		System.out.println("");
		for (int i = 0; i < 10; i++)
		{
		  System.out.print(c++);
			for (int j = 0; j < 10; j++)
			{
			   System.out.print(" *");
				updateBoard[i][j]= " *";
			  
			}
			System.out.println("");
		}
		HitOrmiss = updateBoard;
		return HitOrmiss;
	}
  
  public String [][] HitOrMissBoard(String [][] HitOrMiss, String x, String y, String HorM)
  {
		System.out.println("HIT AND MISS BOARD:");
		StringBuilder sb = new StringBuilder();
		char c = 'A';
		char convertHitOrMiss = HorM.charAt(0);
		char conversion = x.charAt(0);
		  int rowIndex = 0;
	  if ((conversion == 'A') || (conversion == 'A'))
		  {
			  rowIndex = 0;
		  } else if ((conversion == 'b') || (conversion == 'B'))
		  {
			  rowIndex = 1;
		  } else if ((conversion == 'C') || (conversion == 'c'))
		  {
			  rowIndex = 2;
		  } else if ((conversion == 'D') || (conversion == 'd') )
		  {
			  rowIndex = 3;
		  } else if ((conversion == 'E') || (conversion == 'e'))
		  {
			  rowIndex = 4;
		  } else if ((conversion == 'F') || (conversion == 'f'))
		  {
			  rowIndex = 5;
		  } else if ((conversion == 'G') || (conversion == 'g'))
		  {
			  rowIndex = 6;
		  } else if ((conversion == 'H') || (conversion == 'h'))
		  {
			  rowIndex = 7;
		  } else if ((conversion == 'I') || (conversion == 'i'))
		  {
			  rowIndex = 8;
		  } else
		  {
			  rowIndex = 9;
		  }
		 int columnIndex = Integer.parseInt(y);
  
  
		System.out.print(" ");
		for (int i = 0 ; i < 10; i++)
		{
			  System.out.print(" " + i );
		}
		System.out.println("");
		for (int i = 0; i < 10; i++)
		{
		  System.out.print(c++);
			for (int j = 0; j < 10; j++)
			{
			  if (convertHitOrMiss == 'H') {
			  HitOrMiss[rowIndex][columnIndex] = " H";
			  System.out.print(HitOrMiss[i][j]);
			  } else {
			  HitOrMiss[rowIndex][columnIndex] = " M";
			   System.out.print(HitOrMiss[i][j]);
			  }
			}
			System.out.println("");
		}
		return HitOrMiss;
	}
  
	  public String checkHitMiss(String[][] board, String x, String y)
  {
	  int rowIndex = 0;
	  char conversion = x.charAt(0);
	  int columnindex = Integer.parseInt(y);
	  if ((conversion == 'A') || (conversion == 'A'))
		  {
			  rowIndex = 0;
		  } else if ((conversion == 'b') || (conversion == 'B'))
		  {
			  rowIndex = 1;
		  } else if ((conversion == 'C') || (conversion == 'c'))
		  {
			  rowIndex = 2;
		  } else if ((conversion == 'D') || (conversion == 'd') )
		  {
			  rowIndex = 3;
		  } else if ((conversion == 'E') || (conversion == 'e'))
		  {
			  rowIndex = 4;
		  } else if ((conversion == 'F') || (conversion == 'f'))
		  {
			  rowIndex = 5;
		  } else if ((conversion == 'G') || (conversion == 'g'))
		  {
			  rowIndex = 6;
		  } else if ((conversion == 'H') || (conversion == 'h'))
		  {
			  rowIndex = 7;
		  } else if ((conversion == 'I') || (conversion == 'i'))
		  {
			  rowIndex = 8;
		  } else
		  {
			  rowIndex = 9;
		  }
	  for (int i = 0; i < 10; i++)
	  {
		  for (int j = 0; j < 10; j++)
		  {
			if (board[rowIndex][columnindex] == " $") {
			  return "H";
			}
		  }
	  }
	  return "M";
  }
  
	  
	
  public boolean checkOverlap(Space[] placedOn) {
	  for(Space s : placedOn) {
		  if(s.isShipHere() == true)
			  return true;
	  }
	  return false;
  }
	
	public boolean checkOutOfBounds(Ship ship) {
		return false;
	}
  
  }