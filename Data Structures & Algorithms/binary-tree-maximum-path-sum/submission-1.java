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
        if(root == null) return 0;
        int res[] = new int[]{root.val};
        dfs(root, res);
        return res[0];
    }

    public int dfs(TreeNode root, int[] res){
        if(root == null) return 0;

        int left = Math.max(0, dfs(root.left, res));
        int right = Math.max(0, dfs(root.right, res));

        res[0] = Math.max(res[0], left + right + root.val);

        return root.val + Math.max(left, right);
    }
}
