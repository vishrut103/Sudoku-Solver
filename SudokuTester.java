
public class SudokuTester {
	public static void main(String[] args){
		
		//The input(2D int array) is the unsolved puzzle, where 0 represents empty cell
									   //1 2 3 4 5 6 7 8 9 
		int[][] input = new int[][]    {{0,0,0,0,0,0,0,0,0},//1
										{0,0,0,0,0,0,0,0,0},//2
										{0,0,0,0,0,0,0,0,0},//3
										{0,0,0,0,0,0,0,0,0},//4
										{0,0,0,0,0,0,0,0,0},//5
										{0,0,0,0,0,0,0,0,0},//6
										{0,0,0,0,0,0,0,0,0},//7
										{0,0,0,0,0,0,0,0,0},//8
										{0,0,0,0,0,0,0,0,0} //9
										};
		
		//Transferring the 2D input puzzle to a 3D workspace array
		int[][][] sudoku = new int[10][9][9];
		for(int j=0; j<=8; j++)
		{
			for(int k=0; k<=8; k++)
			{
				sudoku[0][j][k]=input[j][k];
			}
		}
		
		//Creating a SudokuSolver object by passing the 3D sudoku workspace to the SudokuSolver constructor
		SudokuSolver solver = new SudokuSolver(sudoku);
		
	}

}

