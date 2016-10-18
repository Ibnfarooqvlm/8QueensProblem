package com.ahamed.eightqueensproblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NQueens {

	int chessBoard[][];
	int n;	
	int a[];
	int solNo = 1;

	NQueens()throws IOException
	{
		System.out.print("Enter n: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		chessBoard = new int[n][n];
		populateValues(n);
	}
	public void reset(int x)
	{
		//Here x denotes the row number.
		//This will clear the mentioned row's values.
		for(int i=0;i<n;i++)			
			chessBoard[x][i]=0;
	}

	public void populateValues(int x)
	{
		if(x>0)
		{
			for(int i=0;i<n;i++)
			{
				//Reset the corresponding row's values:
				reset(x-1);
				chessBoard[x-1][i] = 1;
				populateValues(x-1);
			}
		}
		else
			validateBoard();
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
