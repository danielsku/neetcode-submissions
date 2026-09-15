class Solution {

    List<List<Integer>> adj = new ArrayList<>();
    Set<Integer> visited = new HashSet<>();

    public boolean validTree(int n, int[][] edges) {
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        if(!dfs(0, -1)) return false;
        return visited.size() == n;
    }

    public boolean dfs(int n, int p){
        if(visited.contains(n)) return false;
        visited.add(n);

        for(int nei : adj.get(n)){
            if(nei == p) continue;
            if(!dfs(nei, n)) return false;
        }

        return true;
    }
}
