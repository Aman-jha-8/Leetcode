//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        PrintWriter out=new PrintWriter(System.out);
        
        //taking testcases
        int t = Integer.parseInt(br.readLine()); 
    	for(int i=0;i<t;i++)
    	{
            String str=br.readLine();
    		
    		//input n and d
    	    int n=Integer.parseInt(str);
    		Stack<Integer> stack=new Stack<>();
    		String str1=br.readLine();
    		String[] starr1=str1.split(" ");
    		//inserting elements in the array
    		for(int j=0;j<n;j++)
    		{
    		    stack.push(Integer.parseInt(starr1[j]));
    		}
    		//calling reverse() function
            Solution.reverse(stack);
            for(int j:stack){
                out.print(j+" ");
            }
            out.println();
         }
         out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

// import java.util.Stack;

class Solution
{ 
    static void reverse(Stack<Integer> s)
    {
        if (s.isEmpty()) 
            return;
        
        // Step 2: remove the top element from stack
        int top = s.pop();
        
        // Step 3: recursively reverse the remaining stack
        reverse(s);
        
        // Step 4: insert the element removed in step 2 at the bottom of the stack
        insertAtBottom(s, top);
    }

    private static void insertAtBottom(Stack<Integer> s, int item)
    {
        if (s.isEmpty())
            s.push(item);
        else
        {
            // remove the top item and recursively insert the item
            int temp = s.pop();
            insertAtBottom(s, item);
            
            // push the top item back into the stack
            s.push(temp);
        }
    }
}
