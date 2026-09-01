/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    private HashMap<Integer, Node> visited;
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        this.visited = new HashMap<>();

        Node root = new Node(node.val);
        dfs(root, node);
        return root;
    }

    private void dfs(Node curr, Node prev) {
        visited.put(curr.val, curr);
        for(Node n : prev.neighbors){
            if(!visited.containsKey(n.val)){
                Node a = new Node(n.val);
                curr.neighbors.add(a);
                dfs(a, n);
            } else {
                Node a = visited.get(n.val);
                curr.neighbors.add(a);
            }
        }
    }
}