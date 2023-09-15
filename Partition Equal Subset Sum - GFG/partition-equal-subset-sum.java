//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int equalPartition(int N, int arr[])
    {
        // code here
        
        int sum=0;
        for(int i=0;i<N;i++)
            sum+=arr[i];
        if(sum%2!=0) return 0;
        sum=sum/2;
        int[][] dp = new int[N+1][sum+1];
        for(int i=0;i<=N;i++)
            Arrays.fill(dp[i],-1);
        return solve(arr,0,dp,sum);
        
    }
    
    public static int solve(int[] arr,int i,int[][] dp,int sum){
        if(sum==0) return 1;
        if(i >= arr.length || sum < 0) return 0;
        if(dp[i][sum]!=-1)
            return dp[i][sum];
        if(solve(arr,i+1,dp,sum-arr[i])==1 || solve(arr,i+1,dp,sum) == 1) return dp[i][sum]=1;
        return dp[i][sum] = 0;
    }
}