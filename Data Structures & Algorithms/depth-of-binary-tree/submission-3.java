// Iterative DFS (Stack)

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
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        ArrayDeque<Pair<TreeNode, Integer>> s = new ArrayDeque<>();
        s.push(new Pair<>(root, 1));
        int count = 0;

        while(!s.isEmpty()){
            Pair<TreeNode, Integer> current = s.pop();
            TreeNode node = current.getKey();
            int depth = current.getValue();

            if(node != null){
                count = Math.max(count, depth);

                if(node.left != null) s.push(new Pair<>(node.left, depth + 1));
                if(node.right != null) s.push(new Pair<>(node.right, depth + 1));
            }
           
        }

        return count;

    }
}
