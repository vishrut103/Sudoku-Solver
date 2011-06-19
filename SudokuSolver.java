
public class SudokuSolver{
	
	//3D workspace for solving the sudoku
	public int[][][] sudoku = new int[10][9][9];
	
	public int[][] board = new int[9][9];

	public SudokuSolver(int[][][] input){
		sudoku=input;
		boardUpdate();
		updateOptions();
		selectNext(0,0);		
	}

	public void updateOptions(){
		for(int l=1;l<=9;l++){
			for(int b=0;b<=8;b++){
				for(int h=0;h<=8;h++){
					sudoku[l][b][h]=0;
						}
					}
				}
		for(int j=0; j<=8; j++){
			for(int k=0; k<=8; k++){
				
				//Horizontal check for updating options
				for(int c=0; c<=8; c++){
					if(sudoku[0][j][c]!=0){
						sudoku[sudoku[0][j][c]][j][k]=1;
						}
					}
				
				//Vertical check for updating options
				for(int r=0; r<=8; r++){
					if(sudoku[0][r][k]!=0){
						sudoku[sudoku[0][r][k]][j][k]=1;
						}
					}
				
				//Block Checking
				for(int ri=0; ri<=8; ri++){
					for(int ci=0; ci<=8; ci++){
						if((ri/3==j/3)&&(ci/3==k/3)){
							if(sudoku[0][ri][ci]!=0){
								sudoku[sudoku[0][ri][ci]][j][k]=1;
								}
							}
						}
					}
				}
			}
		}
	
	public void print2Dsudoku(){
        //Testing begin

			for(int b=0;b<=8;b++){
				for(int h=0;h<=8;h++){
					System.out.print(sudoku[0][b][h]);
				}
				System.out.print("\n");
			}
			System.out.print("\n\n");			
		
		//Testing end
	}
	
	public void boardUpdate(){
		for(int r=0; r<=8; r++){
			for(int c=0; c<=8; c++){
				board[r][c]=sudoku[0][r][c];
			}
		}
	}
	
	public void selectNext(int r, int c){
		int ctr=0;
		if(board[r][c]==0){
			for(int i=sudoku[0][r][c]+1;i<=9;i++)
			if(sudoku[i][r][c]==0)
				ctr++;
			
			if(ctr>0){
			for(int i=sudoku[0][r][c]+1;i<=9;i++)
				if(sudoku[i][r][c]==0){
					sudoku[0][r][c]=i;
					updateOptions();
					if(c==8&&r!=8)
						selectNext(r+1,0);
					if(c==8&&r==8)
						print2Dsudoku();
					if(c!=8)
						selectNext(r,c+1);
					break;
					}
				}
			
			else{
					revSN(r,c);
				}
			}
		else{
			if(c==8&&r!=8)
				selectNext(r+1,0);
			if(c==8&&r==8)
				print2Dsudoku();
			if(c!=8)
				selectNext(r,c+1);
		}
	}

    public void undoSelection(int r, int c){
    	if(board[r][c]==0)
    	sudoku[0][r][c]=0;
    	updateOptions();
    }
	

	public void revSN(int r, int c){
		if(possible(r,c)){
			selectNext(r,c);
		}
		else
		{
			if(board[r][c]==0){
				undoSelection(r,c);
				if(r==0&&c==0);
				if(c==0&&r!=0){
						revSN(r-1,8);
				}
				if(c!=0){
						revSN(r,c-1);					
				}
				
			}
			else{
				if(r==0&&c==0)
					System.out.println("er");
				if(c==0&&r!=0){
						revSN(r-1,8);
				}
				if(c!=0){
						revSN(r,c-1);					
				}
				
			}
		}
		
	}
	
	public boolean possible(int r, int c){
		int ctr=0;
		if(board[r][c]==0){
			for(int i=sudoku[0][r][c]+1;i<=9;i++)
			if(sudoku[i][r][c]==0)
				ctr++;
			}
			
		if (ctr>0)
				return true;
		else 
				return false;
	}
}



