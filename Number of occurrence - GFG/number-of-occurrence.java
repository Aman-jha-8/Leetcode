//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().count(arr, n, x);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution {
    int count(int[] arr, int n, int x) {
        int firstIndex = findFirstIndex(arr, n, x);
        int lastIndex = findLastIndex(arr, n, x);
        
        if (firstIndex == -1 || lastIndex == -1) {
            return 0;
        }
        
        return lastIndex - firstIndex + 1;
    }
    
    // Binary search to find the first occurrence of x
    int findFirstIndex(int[] arr, int n, int x) {
        int low = 0, high = n - 1;
        int firstIndex = -1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (arr[mid] == x) {
                firstIndex = mid;
                high = mid - 1; // Continue searching in the left half
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return firstIndex;
    }
    
    // Binary search to find the last occurrence of x
    int findLastIndex(int[] arr, int n, int x) {
        int low = 0, high = n - 1;
        int lastIndex = -1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (arr[mid] == x) {
                lastIndex = mid;
                low = mid + 1; // Continue searching in the right half
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return lastIndex;
    }
}
