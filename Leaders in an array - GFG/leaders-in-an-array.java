//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.stream.*;

class Array {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		
		while(t-->0){
		    
		    //input size of array
		    int n = Integer.parseInt(br.readLine().trim());
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    //inserting elements in the array
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    Solution obj = new Solution();
		    
		    StringBuffer str = new StringBuffer();
		    ArrayList<Integer> res = new ArrayList<Integer>();
		  
		    //calling leaders() function
		    res = obj.leaders(arr, n);
		    

		    for(int i=0; i<res.size(); i++){
		        ot.print(res.get(i)+" ");
		    }
		    
		    ot.println();
		}
		ot.close();
		
	}
}

// } Driver Code Ends


// import java.util.ArrayList;

class Solution {
    // Function to find the leaders in the array.
    static ArrayList<Integer> leaders(int arr[], int n) {
        ArrayList<Integer> result = new ArrayList<>();
        int maxRight = arr[n - 1]; // Initialize the rightmost element as leader

        // Traverse the array from right to left
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] >= maxRight) {
                maxRight = arr[i]; // Update the maximum if the current element is larger
                result.add(maxRight); // Add the leader to the result
            }
        }

        // Reverse the result array to get the leaders in the correct order
        int size = result.size();
        for (int i = 0; i < size / 2; i++) {
            int temp = result.get(i);
            result.set(i, result.get(size - i - 1));
            result.set(size - i - 1, temp);
        }

        return result;
    }
}

