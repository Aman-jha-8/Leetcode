//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
             arr[i] = sc.nextInt();
             
           System.out.println(new Solution().majorityElement(arr, n)); 
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    static int majorityElement(int a[], int size)
    {
        int majorityCandidate = -1; // Initialize the majority candidate
        int count = 0; // Initialize the count of the majority candidate

        for (int i = 0; i < size; i++) {
            if (count == 0) {
                // If count is zero, set the current element as the potential majority candidate
                majorityCandidate = a[i];
                count = 1;
            } else if (a[i] == majorityCandidate) {
                // If the current element matches the potential majority candidate, increment count
                count++;
            } else {
                // If the current element doesn't match the potential majority candidate, decrement count
                count--;
            }
        }

        // Now, 'majorityCandidate' contains the potential majority element.
        // Check if it appears more than N/2 times.
        int frequency = 0;
        for (int i = 0; i < size; i++) {
            if (a[i] == majorityCandidate) {
                frequency++;
            }
        }

        if (frequency > size / 2) {
            return majorityCandidate; // It's the majority element
        } else {
            return -1; // No majority element
        }
    }
}
