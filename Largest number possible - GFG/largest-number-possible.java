//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(a[0]);
            int S = Integer.parseInt(a[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.findLargest(N, S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    static String findLargest(int N, int S){
        // Special case: N is 1 and S is greater than 9, or S is 0 and N is greater than 1
        if ((N == 1 && S > 9) || (S == 0 && N > 1)) {
            return "-1";
        }
        
        // Initialize an array to store digits
        int[] digits = new int[N];
        
        // Fill the array with digits
        for (int i = 0; i < N; i++) {
            if (S >= 9) {
                digits[i] = 9;
                S -= 9;
            } else {
                digits[i] = S;
                S = 0;
            }
        }
        
        // Check if all digits have been used
        if (S == 0) {
            // Convert the array of digits to a string
            StringBuilder result = new StringBuilder();
            for (int digit : digits) {
                result.append(digit);
            }
            return result.toString();
        } else {
            return "-1"; // If S is not zero, it's not possible to form the number
        }
    }
}
