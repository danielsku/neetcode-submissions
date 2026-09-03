class Solution {

    private int[][] heights;
    private int rows, cols;
    private List<List<Integer>> res;
    private int[][] directions = new int[][]{
        {1, 0},
        {-1, 0},
        {0,1},
        {0,-1}
    };

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        this.rows = heights.length;
        this.cols = heights[0].length;
        this.res = new ArrayList<>();

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                boolean[][] visited = new boolean[rows][cols];
                boolean[] touches = new boolean[]{false, false};
                dfs(i, j, touches, visited);
                if(touches[0] && touches[1]) res.add(new ArrayList<>(List.of(i, j)));
            }
        }
        
        return res;
    }

    private void dfs(int i, int j, boolean[] touches, boolean[][] visited){
        visited[i][j] = true;

        for(int[] d : directions){
            int x = d[0];
            int y = d[1];
            
            if(x + i < 0 || y + j < 0) {
                touches[0] = true;
                continue;
            }

            if( x + i >= rows || y + j >= cols) {
                touches[1] = true;
                continue;
            }

            if(!visited[x + i][y + j] && heights[i][j] >= heights[x + i][y + j]){
                dfs(x + i, y + j, touches, visited);
            }
        }
    }
}
