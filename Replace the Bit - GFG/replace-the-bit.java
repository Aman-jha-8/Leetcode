//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0)
        {
            String input[];
            input = br.readLine().trim().split(" ");
            int n = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);
            Solution ob = new Solution();
            
            System.out.println(ob.replaceBit(n,k));    
        }
    }
}
// } Driver Code Ends


class Solution {
    int replaceBit(int N, int K) {
        int p = N,c=0;
        while(p!=0){
            p=p>>1;
            c++;
        }
        return (N & ~(( 1 << c) >> K));              // Use bitwise AND to make the Kth bit '0'

    }
}




