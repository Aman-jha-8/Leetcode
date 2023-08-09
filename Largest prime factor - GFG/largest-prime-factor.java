//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.largestPrimeFactor(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static long largestPrimeFactor(int N) {
        // If N is even, keep dividing it by 2
        while (N % 2 == 0) {
            N /= 2;
        }

        // If N is now 1, then 2 was its largest prime factor
        if (N == 1) {
            return 2;
        }

        long largest = 3; // To store the largest prime factor found
        // Now try dividing N by all odd numbers starting from 3 up to sqrt(N)
        for (long i = 3; i <= Math.sqrt(N); i += 2) {
            while (N % i == 0) {
                N /= i;
                largest = i; // Update largest prime factor found
            }
        }

        // If after the loop, N is greater than 2, then N is a prime number 
        // and the largest prime factor of the original number
        if (N > 2) {
            return N;
        }

        return largest; // return the largest prime factor found
    }
}
