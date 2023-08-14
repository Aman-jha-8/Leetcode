//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine();
            String[] S = s.split(" ");
            int[] v = new int[2 * n + 2];
            for(int i = 0; i < 2 * n + 2; i++)
            {
                v[i] = Integer.parseInt(S[i]);
            }
            Solution ob = new Solution();
            int[] ans = ob.singleNumber(v);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution {
    public int[] singleNumber(int[] nums) {
        int XOR = 0;
        for (int num : nums) {
            XOR ^= num;
        }

        int setBit = XOR & ~(XOR-1); // This gets us the rightmost set bit of XOR

        int x = 0, y = 0;

        for (int num : nums) {
            // Based on the setBit, divide numbers into two groups and XOR them separately
            if ((num & setBit) == 0) {
                x ^= num;
            } else {
                y ^= num;
            }
        }

        if (x > y) { // Ensure ascending order
            return new int[]{y, x};
        }
        return new int[]{x, y};
    }
}
