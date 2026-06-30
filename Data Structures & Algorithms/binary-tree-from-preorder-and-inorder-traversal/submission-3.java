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
    private int pre_idx = 0;
    private HashMap<Integer, Integer> indices = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++){
            indices.put(inorder[i], i);
        }
        return dfs(0, inorder.length - 1, preorder);
    }

    public TreeNode dfs(int l, int r, int[] preorder){
        if(l > r) return null;
        
        int root_val = preorder[pre_idx++];
        TreeNode root = new TreeNode(root_val);
        int mid = indices.get(root_val);

        root.left = dfs(l, mid - 1, preorder);
        root.right = dfs(mid + 1, r, preorder);

        return root;
    }
}
