class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 0;
       
        
        int l = sumOfLeftLeaves(root.left);
        int r= sumOfLeftLeaves(root.right);
        if(l==0 && root.left != null && root.left.left == null && root.left.right ==null){
            l=root.left.val;
        }
        return l + r;
        
    }
}