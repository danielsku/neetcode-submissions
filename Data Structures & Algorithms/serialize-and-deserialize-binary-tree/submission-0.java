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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> values = new ArrayList<>();
        dfsSerialize(root, values);
        return String.join(",", values);
    }

    public void dfsSerialize(TreeNode root, List<String> values){
        if(root == null){
            values.add("N");
            return;
        }

        values.add(String.valueOf(root.val));
        dfsSerialize(root.left, values);
        dfsSerialize(root.right, values);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] tokens = data.split(",");
        int[] i = new int[]{0};
        return dfsDeserialize(tokens, i);
    }

    public TreeNode dfsDeserialize(String[] tokens, int[] i){
        if(tokens[i[0]].equals("N")){
            i[0]++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(tokens[i[0]++]));

        node.left = dfsDeserialize(tokens, i);
        node.right = dfsDeserialize(tokens, i);

        return node;
    }
}
