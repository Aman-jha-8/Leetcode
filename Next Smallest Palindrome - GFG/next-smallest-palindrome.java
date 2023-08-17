//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int num[] = new int[n];
            String[] str = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                num[i] = Integer.parseInt(str[i]);
            }

            Vector<Integer> ans = new Solution().generateNextPalindrome(num, n);
            for (Integer x : ans) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// import java.util.Vector;

class Solution {
    public Vector<Integer> generateNextPalindrome(int num[], int n) {
        Vector<Integer> res = new Vector<>();
        boolean isAllNine = true;
        
        // Check if all digits are 9
        for(int i = 0; i < n; i++) {
            if(num[i] != 9) {
                isAllNine = false;
                break;
            }
        }
        
        if(isAllNine) {
            res.add(1);
            for(int i = 0; i < n-1; i++) res.add(0);
            res.add(1);
            return res;
        }

        // Normal case: not all digits are 9
        int mid = n/2;
        boolean leftIsSmaller = false;
        int i = mid - 1;
        int j = (n % 2 == 0) ? mid : mid + 1;

        // Ignore the middle same digits
        while(i >= 0 && num[i] == num[j]) {
            i--;
            j++;
        }

        if(i < 0 || num[i] < num[j]) leftIsSmaller = true;

        // Copy the reversed left half to the right half
        while(i >= 0) {
            num[j] = num[i];
            j++;
            i--;
        }

        if(leftIsSmaller) {
            int carry = 1;
            i = mid - 1;

            // For odd digits, need to consider the middle digit separately
            if(n % 2 == 1) {
                num[mid] += carry;
                carry = num[mid] / 10;
                num[mid] %= 10;
                j = mid + 1;
            } else {
                j = mid;
            }

            while(i >= 0) {
                num[i] += carry;
                carry = num[i] / 10;
                num[i] %= 10;
                num[j++] = num[i--];  // Copy the mirrored digit to the right half
            }
        }

        // Copy the resultant palindrome to the result
        for(i = 0; i < n; i++) res.add(num[i]);
        return res;
    }
}
