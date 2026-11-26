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
    public int maxPathSum(TreeNode root) {
        int r[] = new int[]{root.val};
        dfs(root, r);
        return r[0];
    }

    private int dfs(TreeNode node, int[] r){
        if(node == null) return 0;

        int leftMax = Math.max(dfs(node.left, r), 0);
        int rightMax = Math.max(dfs(node.right, r), 0);

        r[0] = Math.max(r[0], node.val + leftMax + rightMax);

        return node.val + Math.max(leftMax, rightMax);
    }
}
