class Solution {
    private boolean[][] visited;
    private int[][] grid, timeGrid;
    private int rows, cols;
    private ArrayDeque<int[]> q;
    private int[][] directions = new int[][]{
        {1,0},
        {-1,0},
        {0,1},
        {0,-1},
    };

    public int orangesRotting(int[][] grid) {
        this.grid = grid;
        this.rows = grid.length;
        this.cols = grid[0].length;

        // Initiliaze a grid to keep track of time
        timeGrid = new int[rows][cols];

        for (int[] row : timeGrid) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        this.visited = new boolean[rows][cols];
        this.q = new ArrayDeque<>();

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(!visited[i][j] && grid[i][j] == 2) {
                    timeGrid[i][j] = 0;
                    q.add(new int[]{i, j});
                }
            }
        }

        bfs();
        
        int minTime = 0;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
               System.out.print(timeGrid[i][j] + " ");
            }
               System.out.println();
        }

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if( grid[i][j] == 1) return -1;
                if(grid[i][j] == 2) minTime = Math.max(minTime, timeGrid[i][j]);
            }
        }


        return minTime;
    }

    private void bfs() {

        while(!q.isEmpty()){
            int[] n = q.poll();
            int x = n[0];
            int y = n[1];
            for(int[] d : directions){
                int i = d[0];
                int j = d[1];

                if(x + i >= 0 && y + j >= 0 
                && x + i < rows && y + j < cols 
                && !visited[x + i][y + j] && grid[x + i][y + j] == 1){
                    timeGrid[x + i][y + j] = Math.min(
                        timeGrid[x + i][y + j], timeGrid[x][y] + 1
                    );
                    grid[x + i][y + j] = 2;
                    visited[x + i][y + j] = true;
                    q.add(new int[]{x + i, y + j});
                }
            }
        }
    }
}
