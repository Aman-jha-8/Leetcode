//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver_class
{
    public static void main(String args[])
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int grid[][] = new int[9][9];
            for(int i = 0; i < 9; i++)
            {
                for(int j = 0; j < 9; j++)
                grid[i][j] = sc.nextInt();
            }
            
            Solution ob = new Solution();
            
            if(ob.SolveSudoku(grid) == true)
                ob.printGrid(grid);
            else
                System.out.print("NO solution exists");
            System.out.println();
            
        }
    }
}




// } Driver Code Ends


//User function Template for Java

class Solution
{
    // Checks whether it will be legal to assign num to the given row, col.
    static boolean isSafe(int[][] board, int row, int col, int num)
    {
        // Check if 'num' is not already placed in current row, 
        // current column and current 3x3 box
        for (int d = 0; d < board.length; d++)
        {
            // Check row and column
            if (board[row][d] == num || board[d][col] == num)
            {
                return false;
            }
        }

        // Check 3 x 3 box
        int sqrt = (int) Math.sqrt(board.length);
        int boxRowStart = row - row % sqrt;
        int boxColStart = col - col % sqrt;

        for (int r = boxRowStart; r < boxRowStart + sqrt; r++)
        {
            for (int d = boxColStart; d < boxColStart + sqrt; d++)
            {
                if (board[r][d] == num)
                {
                    return false;
                }
            }
        }

        // If there is no clash, it's safe
        return true;
    }

    static boolean SolveSudoku(int grid[][])
    {
        int N = grid.length;
        int row = -1;
        int col = -1;
        boolean isEmpty = true;
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++) 
            {
                if (grid[i][j] == 0) 
                {
                    row = i;
                    col = j;
                    isEmpty = false; 
                    break;
                }
            }
            if (!isEmpty)
            {
                break;
            }
        }

        // No empty space left
        if (isEmpty)
        {
            return true;
        }

        // Else for each-row backtrack
        for (int num = 1; num <= N; num++)
        {
            if (isSafe(grid, row, col, num))
            {
                grid[row][col] = num;
                if (SolveSudoku(grid))
                {
                    // If recursion successful
                    return true;
                }
                else
                {
                    // If fails then undo the move
                    grid[row][col] = 0;
                }
            }
        }
        return false;
    }

    static void printGrid(int grid[][])
    {
        for (int r = 0; r < grid.length; r++)
        {
            for (int d = 0; d < grid.length; d++)
            {
                System.out.print(grid[r][d]);
                System.out.print(" ");
            }
        }
    }
}
