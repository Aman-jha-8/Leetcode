//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {
            String[] nk = br.readLine().trim().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            Solution sln = new Solution();
            ArrayList<ArrayList<Integer>> ans = sln.fourSum(a, k);
            for (ArrayList<Integer> v : ans) {
                for (int u : v) {
                    System.out.print(u + " ");
                }
                System.out.print("$");
            }
            if (ans.isEmpty()) {
                System.out.print(-1);
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// arr[] : int input array of integers
// k : the quadruple sum required




class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
        // code here
         ArrayList<ArrayList<Integer>> shiv=new ArrayList<ArrayList<Integer>>();
        int temp1=Integer.MAX_VALUE,emp1=Integer.MAX_VALUE;
        int index=0;
        if(arr.length<4){
            return shiv;
        }
        Arrays.sort(arr);
        for(int i=0;i<arr.length-3;i++){
            int a=arr[i];
            for(int j=i+1;j<arr.length-2;j++){
                if(i>=1){
                    if(a==arr[i-1]){
                        break;
                    }
                }
                int b=arr[j];
                int k1=j+1,l=arr.length-1;
                while(k1<l){
                    if(j>i+1){
                        if(arr[j]==arr[j-1]){
                            break;
                        }
                    }
                    int sum=k-a-b;
                    int try1=arr[k1]+arr[l];
                    if(try1==sum && (arr[k1]!=temp1 || arr[l]!=emp1)){
                        shiv.add(index,new ArrayList<Integer>(Arrays.asList(arr[i],arr[j],arr[k1],arr[l])));
                        index++;
                        temp1=arr[k1];
                        emp1=arr[l];
                        k1++;
                        l--;
                    }
                    else if(try1>sum){
                        l--;
                    }
                    else{
                        k1++;
                    }
                }
                temp1=Integer.MAX_VALUE;
                emp1=Integer.MAX_VALUE;
            }
        }
        return shiv;
    }
}