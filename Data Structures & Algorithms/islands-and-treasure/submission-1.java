class Solution {
    private int[][] grid;
    private int rows, cols;

    private int[][] directions = {
        {-1, 0},  // up
        {1, 0},   // down
        {0, -1},  // left
        {0, 1}    // right
    };

    private ArrayDeque<int[]> queue = new ArrayDeque<>();
    private boolean[][] visited;

    
    public void islandsAndTreasure(int[][] grid) {
        this.grid = grid;
        this.rows = grid.length;
        this.cols = grid[0].length;
        this.visited = new boolean[grid.length][grid[0].length];

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 0){ 
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        bfs();
    }

    public void bfs(){
        int distance = 0;
        while(!queue.isEmpty()){
            int[] n = queue.poll();
            int x = n[0];
            int y = n[1];

            for(int[] d : directions){
                if(x + d[0] < 0 
                    || y + d[1] < 0 
                    || x + d[0] >= grid.length 
                    || y + d[1] >= grid[0].length
                    || grid[x + d[0]][y + d[1]] == -1) continue;

                if(visited[x + d[0]][y + d[1]]) continue;

                visited[x + d[0]][y + d[1]] = true;
                queue.add(new int[]{x + d[0], y + d[1]});
                grid[x + d[0]][y + d[1]] = Math.min(
                    grid[x + d[0]][y + d[1]],
                    grid[x][y] + 1
                );
            }
        }

    }
}
