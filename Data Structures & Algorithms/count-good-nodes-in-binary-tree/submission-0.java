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
    public int goodNodes(TreeNode root) {
        if(root == null) return 0;
        return findGood(root.left, root.val) + findGood(root.right, root.val) + 1;
    }

    public int findGood(TreeNode root, int max){
        int goods = 0;
        if(root == null) return goods;

        if(root.val >= max){
            goods++;
            max = root.val;
        }
        
        return findGood(root.left, max) + findGood(root.right, max) + goods;
    }
}
