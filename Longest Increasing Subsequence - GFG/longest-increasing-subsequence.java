//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total testcases
        int t = sc.nextInt();
        while(t > 0){
            
            //taking size of array
            int n = sc.nextInt();
            int array[] = new int[n];
            
            //inserting elements in the array
            for (int i = 0; i < n; ++i)
            {
                array[i] = sc.nextInt();
            }
            
            //creating an object of class Solution
            Solution ob = new Solution();
            
            //calling longestSubsequence() method of class
            //Solution
            System.out.println(ob.longestSubsequence(n,array));
            t--;
        }
    } 
} 
// } Driver Code Ends




class Solution 
{
    // Function to do a binary search in tails[] to find the index where a[i] should be placed.
    static int ceilIndex(int tails[], int l, int r, int key) 
    {
        while (r - l > 1) 
        {
            int m = l + (r - l) / 2;
            if (tails[m] >= key)
                r = m;
            else
                l = m;
        }
        return r;
    }

    // Function to find the length of the longest increasing subsequence.
    static int longestSubsequence(int size, int a[]) 
    {
        if (size == 0)
            return 0;

        int tails[] = new int[size];
        int length = 1; // Always points to empty slot in tails.

        tails[0] = a[0];
        
        for (int i = 1; i < size; i++) 
        {
            if (a[i] < tails[0])
                tails[0] = a[i];  // New smallest value.
            else if (a[i] > tails[length - 1])
                tails[length++] = a[i];  // A[i] extends largest subsequence.
            else
                tails[ceilIndex(tails, -1, length - 1, a[i])] = a[i];  // A[i] wants to be current end candidate of an existing subsequence.
        }
        return length;
    }
}
