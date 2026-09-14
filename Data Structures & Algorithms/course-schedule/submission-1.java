class Solution {
    private Map<Integer, List<Integer>> adjMap;
    private Set<Integer> visited;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        // Adjacency List (Map)
        adjMap = new HashMap<>();
        // Visited Set
        visited = new HashSet<>();

        for(int i = 0; i < numCourses; i++){
            adjMap.put(i, new ArrayList<>());
        }

        for(int[] prereq : prerequisites){
            adjMap.get(prereq[0]).add(prereq[1]);
        }

        for(int c = 0; c < numCourses; c++){
            if(!dfs(c)) return false;
        }

        return true;
    }

    public boolean dfs(int u){
        if(visited.contains(u)) return false;
        if(adjMap.isEmpty()) return true;

        visited.add(u);
        List<Integer> desc = adjMap.get(u);
        for(int d : desc){
            if(!dfs(d)) return false;
        }

        // Mark as done
        visited.remove(u);
        adjMap.put(u, new ArrayList<>());
        return true;
    }
}
