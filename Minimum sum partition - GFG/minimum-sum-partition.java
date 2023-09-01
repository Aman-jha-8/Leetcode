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
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java
class Solution {
    public int minDifference(int arr[], int n) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }

        // Calculate the range of possible subset sums (from 0 to half of the total sum)
        int range = sum / 2 + 1;

        // Initialize a dp array to store whether it's possible to get a sum i
        boolean[] dp = new boolean[range];
        dp[0] = true;

        // Populate the dp array
        for (int num : arr) {
            for (int j = range - 1; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }

        // Find the maximum sum that can be achieved in the first half
        int maxSum = 0;
        for (int i = range - 1; i >= 0; i--) {
            if (dp[i]) {
                maxSum = i;
                break;
            }
        }

        // Calculate the minimum difference
        int minDiff = Math.abs(sum - 2 * maxSum);
        return minDiff;
    }
}
