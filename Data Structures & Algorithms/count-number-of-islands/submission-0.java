class Solution {

    private char[][] grid;
    private boolean[][] visited;
    private int rows, cols;

    public int numIslands(char[][] grid) {
        this.grid = grid;
        this.rows = grid.length;
        this.cols = grid[0].length;
        this.visited = new boolean[rows][cols];
    
        int numIslands = 0;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(!visited[i][j] && grid[i][j] == '1') {
                    dfs(i, j);
                    numIslands++;
                }
            }
        }

        return numIslands;
    }

    private void dfs(int i, int j) {
        if( i < 0 || j < 0 
        || i >= rows || j >= cols || 
        grid[i][j] == '0' || visited[i][j]) return;

        visited[i][j] = true;
        
        dfs(i + 1, j);
        dfs(i - 1, j);
        dfs(i, j + 1);
        dfs(i, j - 1);
    }
}
