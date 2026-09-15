class Solution {
    List<List<Integer>> adj = new ArrayList<>();
    Set<Integer> visited = new HashSet<>();

    public int countComponents(int n, int[][] edges) {
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for(int[] e : edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        int numComp = 0;
        for(int i = 0; i < n; i++){
            if(!visited.contains(i)){
                dfs(i);
                numComp++;
            }
        }

        return numComp;
    }

    private void dfs(int n){
        visited.add(n);

        for(int nei : adj.get(n)){
            if(visited.contains(nei)) continue;
            dfs(nei);
        }
    }
}
