//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Main {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		sc.nextLine();
		while(T-->0)
		{
		    
		    Solution ob=new Solution();
		    
		    String S=sc.nextLine();
		    
		    ArrayList<String> arr = ob.permutation(S);
		    for(String s : arr){
		        System.out.print(s+" ");
		    }
		    System.out.println();
		}
		
	}
}

// } Driver Code Ends


//User function Template for Java


// import java.util.*;

class Solution
{
    // Helper function to swap characters at two positions
    static void swap(char[] ch, int i, int j)
    {
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }
    
    // Function to generate permutations recursively
    static void permute(char[] ch, int currentIndex, ArrayList<String> res)
    {
        if (currentIndex == ch.length - 1) 
        {
            res.add(String.valueOf(ch));
        }
 
        for (int i = currentIndex; i < ch.length; i++)
        {
            swap(ch, currentIndex, i);
            permute(ch, currentIndex + 1, res);
            swap(ch, currentIndex, i); // backtrack step (restore the string to its original form)
        }
    }

    public ArrayList<String> permutation(String S)
    {
        // Convert string to char array
        char[] ch = S.toCharArray();
        
        // Result list to hold permutations
        ArrayList<String> res = new ArrayList<String>();
        
        // Generate permutations
        permute(ch, 0, res);
        
        // Sort the result list
        Collections.sort(res);
        
        return res;
    }
	   
}
