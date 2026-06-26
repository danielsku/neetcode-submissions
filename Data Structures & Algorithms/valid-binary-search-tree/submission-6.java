/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isValidBST(TreeNode root) {
        return checkBST(root.left, Integer.MIN_VALUE, root.val) && checkBST(root.right, root.val, Integer.MAX_VALUE);
    }

    public boolean checkBST(TreeNode root, int left, int right){
        if(root == null) return true;

        if(root.val <= left) return false;
        if(root.val >= right) return false;

        return checkBST(root.left, left, root.val) && checkBST(root.right, root.val, right);

        
    }
}
