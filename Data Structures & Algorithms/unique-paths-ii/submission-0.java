class Solution {
    int cache[][];
    int obstacleGrid[][];
    int ROWS, COLS;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        this.ROWS = obstacleGrid.length;
        this.COLS = obstacleGrid[0].length;
        this.obstacleGrid = obstacleGrid;

        this.cache = new int[ROWS][COLS];
        for(int[] c : cache) Arrays.fill(c, -1);

        return dp(0, 0);
    }

    private int dp(int i, int j){
        if(i == ROWS || j == COLS || obstacleGrid[i][j] == 1)
            return 0;
        
        if(i == ROWS - 1 && j == COLS - 1) return 1;

        if(cache[i][j] != -1) return cache[i][j];

        return cache[i][j] = dp(i + 1, j) + dp(i, j + 1);
    }
}