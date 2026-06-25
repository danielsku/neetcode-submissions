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
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();

        q1.offer(a);
        q2.offer(b);

        while(!q1.isEmpty() && !q2.isEmpty()){
            int size = q2.size();

            for(int i = 0; i < size; i++){
                TreeNode node1 = q1.poll();
                TreeNode node2 = q2.poll();

                if(node1 == null && node2 == null) continue;
                if(node1 == null || node2 == null || node1.val != node2.val) return false;
                

                q1.offer(node1.left);
                q2.offer(node2.left);    
                q1.offer(node1.right);
                q2.offer(node2.right);

            }
        }
        
        return q2.isEmpty();
    }
}
