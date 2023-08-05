//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            ArrayList<Integer> arr = new ArrayList<>();
            for(int i = 0;i<n;i++)
                {
                    int x = sc.nextInt();
                    arr.add(x);
                }
            int m = sc.nextInt();
            
            Solution ob = new Solution();
            
    		System.out.println(ob.findMinDiff(arr,n,m));
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java

// import java.util.Collections;
class Solution
{
    public long findMinDiff (ArrayList<Integer> a, int n, int m)
    {
        // sort the given array
        Collections.sort(a);
        
        // initialize the minimum difference as the maximum possible value
        long min_diff = Long.MAX_VALUE;
        
        // iterate the window on the sorted array
        for (int i = 0; i < n - m + 1; i++)
        {
            // calculate the difference of the maximum and minimum
            // chocolate packet in the current window
            long diff = a.get(i + m - 1) - a.get(i);
            
            // update the minimum difference
            if (diff < min_diff)
            {
                min_diff = diff;
            }
        }
        
        // return the minimum difference.
        return min_diff;
    }
}
