// Second Attempt


class Solution {

    private List<List<Integer>> adj = new ArrayList<>();
    private Set<Integer> cycle = new HashSet<>();
    private boolean[] visited;
    private int cycleStart;


    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        for(int i = 0; i <= n; i++) adj.add(new ArrayList<>());

        for(int[] e : edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }


        visited = new boolean[n + 1];
        cycleStart = -1;

        dfs(1, -1);

        for(int i = edges.length - 1; i >= 0; i--){
            int u = edges[i][0];
            int v = edges[i][1];
            if(cycle.contains(u) && cycle.contains(v)){
                return new int[]{u, v};
            }
        }

        return new int[0];
    }

    private boolean dfs(int n, int p){
        if(visited[n]){
            cycleStart = n;
            return true;
        }

        visited[n] = true;

        for(int nei : adj.get(n)){
            if(nei == p) continue;
            if(dfs(nei, n)){
                if(cycleStart != -1) cycle.add(n);
                if(n == cycleStart) cycleStart = -1;
                return true;
            }
        }

        return false;
    }
}
