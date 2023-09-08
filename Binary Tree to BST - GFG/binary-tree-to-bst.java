//{ Driver Code Starts
//Initial Template for Java

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GFG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root){
        if(root == null)
            return;
        printInorder(root.left);
        System.out.print(root.data+" ");
        printInorder(root.right);
    }
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t > 0){
            String s = br.readLine();
            Node root = buildTree(s);
            Solution g = new Solution();
            Node rootA = g.binaryTreeToBST(root);
            printInorder(rootA);
            System.out.println();
            t--;
        }
    }
}


// } Driver Code Ends



//User function Template for Java

/*Structure of the node class is
class Node
{
    int data;
    Node left, right;
    Node(int item){
        data = item;
        left = right = null;
    }
} */


// class Solution
// {
//     // The given root is the root of the Binary Tree
//     // Return the root of the generated BST
//     private static int idx=0;
//      Node binaryTreeToBST(Node root)
//     {
//       // Your code here
//       if(root==null) return null;
//       ArrayList<Integer>list=new ArrayList<>();
//       inorder(root,list);
//       Collections.sort(list);
       
//       inorderChange(root,list);
//       return root;
//     }
//     public void inorder(Node root,ArrayList<Integer>list){
//         if(root==null) return;
//         inorder(root.left,list);
//         list.add(root.data);
//         inorder(root.right,list);
//     }
//     public void inorderChange(Node root,ArrayList<Integer>list){
//         if(root==null) return;
//         inorderChange(root.left,list);
//         root.data = list.get(idx);
//         idx++;
//         inorderChange(root.right,list);
//     }
// }
 
 
 class Solution {
    private static int idx = 0;

    Node binaryTreeToBST(Node root) {
        if (root == null)
            return null;

        // Step 1: In-order traversal to collect values
        ArrayList<Integer> list = new ArrayList<>();
        inorder(root, list);

        // Step 2: Sort the list
        Collections.sort(list);

        // Step 3: Build a new BST using the sorted values
        idx = 0; // Reset the index
        return buildBST(root, list);
    }

    private void inorder(Node root, ArrayList<Integer> list) {
        if (root == null)
            return;
        inorder(root.left, list);
        list.add(root.data);
        inorder(root.right, list);
    }

    private Node buildBST(Node root, ArrayList<Integer> list) {
        if (root == null)
            return null;

        // Recursively build the left and right subtrees
        root.left = buildBST(root.left, list);
        root.data = list.get(idx);
        idx++;
        root.right = buildBST(root.right, list);

        return root;
    }
}
