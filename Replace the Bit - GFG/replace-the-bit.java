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


// //User function Template for Java

// class Solution{
//     int replaceBit(int N, int K){
//         int mask = 1 << (K - 1); // Create a mask with '1' at the Kth position
//         if ((N & mask) != 0) {   // Check if the Kth bit is '1'
//             N = N & ~mask;      // Use bitwise AND to make the Kth bit '0'
//         }
//         return N;
//     }
// }

// class Solution {
//     int replaceBit(int N, int K) {
//         int mask = 1 << (K - 1); // Create a mask with '1' at the Kth position
//         if ((N & mask) != 0) {   // Check if the Kth bit is '1'
//             N = N ^ mask;        // Use bitwise XOR to make the Kth bit '0'
//         }
//         return N;
//     }
// }

class Solution {
    int replaceBit(int N, int K) {
        int p = N;
        int c=0;
        while(p!=0){
            p=p>>1;
            c++;
        }
        int m= 1 << c;
        m= m  >> K;
        m = ~m;
         // Create a mask with '0' at the Kth position
        N = N & m;              // Use bitwise AND to make the Kth bit '0'
        return N;
    }
}




