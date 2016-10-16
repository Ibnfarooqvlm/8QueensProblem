package com.ahamed.eightqueensproblem;

public class EightQueens {

	int chessBoard[][];
	int n=8;
	int a[];
	int solNo = 1;

	EightQueens()
	{
		chessBoard = new int[n][n];				
	}
	public void reset()
	{
		for(int i=0;i<8;i++)
			for(int j=0;j<8;j++)
				chessBoard[i][j]=0;
	}
	public void populateValues()
	{
		a = new int[n];
		for(a[0]=0;a[0]<n;a[0]++)
			for( a[1]=0;a[1]<n;a[1]++)
				for( a[2]=0;a[2]<n;a[2]++)
					for( a[3]=0;a[3]<n;a[3]++)
						for( a[4]=0;a[4]<n;a[4]++)
							for( a[5]=0;a[5]<n;a[5]++)
								for( a[6]=0;a[6]<n;a[6]++)
									for( a[7]=0;a[7]<n;a[7]++)										
									{
										//Reset columns
										reset();
										//Fill up ones
										for(int i=0;i<n;i++)
											chessBoard[i][a[i]] = 1;	
										validateBoard();
									}
	}
	
	public boolean validateBoard()
	{
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				if(chessBoard[i][j] == 1)
					if(checkIntersection(i,j) == true)
						return true;
		display();
		return false;
	}

	public boolean checkIntersection(int rowNum,int colNum)
	{
		boolean rowFlag = false;
		boolean diagonalFlag = false;

		//checking that row whether any other row contains one
		for(int i=0;i<n;i++)
		{
			if(i!=rowNum)
				if(chessBoard[i][colNum]==1)
				{
					rowFlag = true;
					break;
				}
		}

		//Checking the 2nd quarter
		int x=1,y=1;
		while(rowNum+x<n && colNum+y<n)
		{
			if(chessBoard[rowNum+x][colNum+y]==1)
			{
				diagonalFlag = true;
				break;
			}
			x++;
			y++;
		}

		//Checking the 4th quarter
		x=1;
		y=1;
		while(rowNum-x >= 0 && colNum-y >= 0)
		{
			if(chessBoard[rowNum-x][colNum-y]==1)
			{
				diagonalFlag = true;
				break;
			}
			x++;
			y++;
		}

		//Checking the 1st quarter
		x=1;
		y=1;
		while(rowNum-x >= 0 && colNum+y < n)
		{
			if(chessBoard[rowNum-x][colNum+y]==1)
			{
				diagonalFlag = true;
				break;
			}
			x++;
			y++;
		}

		//Checking the 3rd quarter
		x=1;
		y=1;
		while(rowNum+x < n && colNum-y >= 0)
		{
			if(chessBoard[rowNum+x][colNum-y]==1)
			{
				diagonalFlag = true;
				break;
			}
			x++;
			y++;
		}
		//if flag remains false, all the conditions are satisfied.
		if(rowFlag == false && diagonalFlag == false)
			return false;
		return true;
	}

	public void display()
	{
		System.out.println("\nSolution No.: "+solNo++);
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(chessBoard[i][j] + " ");
			}
			System.out.println();
		}
	}
}
