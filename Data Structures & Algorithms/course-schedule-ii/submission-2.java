// Second Attempt : Topological Sort

class Solution {
    private List<Integer> output = new ArrayList<>();
    int[] indegree;
    private List<List<Integer>> adj = new ArrayList<>();

    private void dfs(int c){
        output.add(c);
        indegree[c]--;
        for(int nei : adj.get(c)){
            indegree[nei]--;
            if(indegree[nei] == 0) dfs(nei);
        }
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        for(int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());

        indegree = new int[numCourses];
        for(int[] p : prerequisites) {
            indegree[p[0]]++;
            adj.get(p[1]).add(p[0]);
        }

        for(int i = 0; i < adj.size(); i++) {
            if(indegree[i] == 0) dfs(i);
        }

        if(output.size() != numCourses) return new int[0];

        int[] res = new int[output.size()];
        
        for(int i = 0; i < output.size(); i++){
            res[i] = output.get(i);
        }

        return res;
    }
}
