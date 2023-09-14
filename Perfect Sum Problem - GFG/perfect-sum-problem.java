//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int sum = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                    arr[i] = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.perfectSum(arr,n,sum));
                }
        }
}    
// } Driver Code Ends




class Solution{

	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    // Your code goes here
	     int [][] dp = new int[n][sum+1];
	    
	    for (int i = 0; i < n; i++) {
	        for (int j = 0; j <= sum; j++) {
	            dp[i][j] = -1;
	        }
	    }
	    
	    return solve(0, sum, dp, arr);
	}
	
	private int solve(int i, int j, int [][] dp, int [] arr) {
	    int mod = 1000000007;
	    
	    if (j < 0) return 0;
	    
	    if (i >= arr.length) {
	        if (j == 0) return 1;
	        return 0;
	    }
	    
	    if (dp[i][j] != -1) {
	        return dp[i][j];
	    }
	    
	    dp[i][j] = ((solve(i+1, j, dp, arr) % mod) + (solve(i+1, j-arr[i], dp, arr) % mod)) % mod;
	    return dp[i][j];
	} 
}