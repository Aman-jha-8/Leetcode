//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}




// } Driver Code Ends


class Solution
{
    // Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n)
    {
        // Create a 2D DP array to store the maximum values for different capacities and items.
        int[][] dp = new int[n + 1][W + 1];

        // Initialize the DP array with zeros for the base case (no items or capacity).
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                }
            }
        }

        // Fill the DP array using a bottom-up approach.
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= W; w++) {
                if (wt[i - 1] <= w) {
                    // If the current item's weight is less than or equal to the capacity,
                    // we have two choices: either include the item or exclude it.
                    // We take the maximum of the two choices.
                    dp[i][w] = Math.max(val[i - 1] + dp[i - 1][w - wt[i - 1]], dp[i - 1][w]);
                } else {
                    // If the current item's weight exceeds the capacity, we can't include it.
                    // So, the value at this cell is the same as the value without this item.
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        // The result is stored in the bottom-right cell of the DP array.
        return dp[n][W];
    }
}



