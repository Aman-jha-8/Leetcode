//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int start = sc.nextInt();
            int end = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.minimumMultiplications(a, start, end);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends






// User function Template for Java

class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {
if(start==end){
    return 0;
}
        // Your code here
        Queue<int[]> q= new LinkedList<>();
        int visi[]= new int[100000];
        q.add(new int[]{start,0});
        while(!q.isEmpty()){
            int ans[]= q.poll();
            int val=ans[0];
            int step=ans[1];
           
            
            for(int i=0;i<arr.length;i++){
                
                long tem=(val*arr[i] )% 100000;
                int ns=(int) tem;
                 if(ns==end){
                return step+1;
            }
            


                if(visi[ns]==0){
                                    // System.out.println(tempo);
visi[ns]=1;
                q.add(new int[]{ns,step+1});
                
                } 
                
            }
            
            
            
            
        }
        return -1;
        
    }
}