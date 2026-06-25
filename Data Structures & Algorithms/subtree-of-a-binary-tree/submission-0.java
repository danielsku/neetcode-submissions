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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) return false;

        if(root.val == subRoot.val){
            if(sameTree(root, subRoot)) return true;
        }

        if(root.left != null && isSubtree(root.left, subRoot)) return true;
        if(root.right != null && isSubtree(root.right, subRoot)) return true;

        return false;

    }

    public boolean sameTree(TreeNode a, TreeNode b){
        if(a == null && b == null) return true;
        ArrayDeque<TreeNode> q1 = new ArrayDeque<>();
        ArrayDeque<TreeNode> q2 = new ArrayDeque<>();

        q1.offer(a);
        q2.offer(b);

        while(!q1.isEmpty() && !q2.isEmpty()){
            int size = q2.size();

            for(int i = 0; i < size; i++){
                TreeNode node1 = q1.poll();
                TreeNode node2 = q2.poll();

                if(node1.val != node2.val) return false;
                
                if((node1.left == null) != (node2.left == null)) return false;
                if((node1.right == null) != (node2.right == null)) return false;

                if(node1.left != null){
                    q1.offer(node1.left);
                    q2.offer(node2.left);
                }
                
                if(node2.right != null){
                    q1.offer(node1.right);
                    q2.offer(node2.right);
                }
            }
        }
        
        return q2.isEmpty();
    }
}
