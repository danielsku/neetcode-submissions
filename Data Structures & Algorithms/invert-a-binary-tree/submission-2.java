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
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.push(root);

        while(!q.isEmpty()){
            int size = q.size();
            TreeNode node = q.pop();

            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if(node.left != null) q.push(node.left);
            if(node.right != null) q.push(node.right);                                 
        }

        return root;
    }
}
