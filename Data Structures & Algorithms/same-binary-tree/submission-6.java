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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        ArrayDeque<TreeNode> q1 = new ArrayDeque<>();
        ArrayDeque<TreeNode> q2 = new ArrayDeque<>();

        if(p != null) q1.offer(p);
        if(q != null) q2.offer(q);

        while(!q1.isEmpty() && !q2.isEmpty()){
            
            TreeNode n1 = q1.poll();
            TreeNode n2 = q2.poll();

            if(n1 == null && n2 == null) continue;
            if(n1.val != n2.val) return false;
            
            if((n1.left == null) != (n2.left == null)) return false;
            if((n1.right == null) != (n2.right == null)) return false;

            if(n1.left != null){
                q1.offer(n1.left);
                q2.offer(n2.left);
            }
            
            if(n1.right != null){
                q1.offer(n1.right);
                q2.offer(n2.right);
            }
        }

        return q1.isEmpty() && q2.isEmpty();
    
    }
}
