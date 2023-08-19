//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main{
	static BufferedReader br;
    static PrintWriter ot;
    public static void main(String[] args) throws IOException{
        
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            
            String s[] = br.readLine().trim().split(" ");
            
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            int a[] = new int[n];
            s = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                a[i] = Integer.parseInt(s[i]);
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.subarraySum(a, n, k);
            for(int ii = 0;ii<res.size();ii++)
                ot.print(res.get(ii) + " ");
            ot.println();
        }
        ot.close();
    }

}
// } Driver Code Ends


class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        ArrayList<Integer> result = new ArrayList<>();
        int start = 0; // Start index of the subarray
        int end = 0;   // End index of the subarray
        int currentSum = 0; // Current sum of elements in the subarray

        while (end < n) {
            // Expand the subarray
            currentSum += arr[end];

            // Shrink the subarray
            while (currentSum > s && start < end) {
                currentSum -= arr[start];
                start++;
            }

            if (currentSum == s) {
                // Found a subarray with the given sum
                result.add(start + 1); // 1-based indexing
                result.add(end + 1);   // 1-based indexing
                return result;
            }

            end++; // Expand the subarray further
        }

        // If no subarray is found, return [-1]
        result.add(-1);
        return result;
    }
}
