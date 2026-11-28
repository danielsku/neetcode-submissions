class Solution {
    int grid[][];
    int cache[][]; 
    int r, c;
    public int minPathSum(int[][] grid) {
        this.grid = grid;
        this.r = grid.length;
        this.c = grid[0].length;

        this.cache = new int[r + 1][c + 1];
        for(int[] c : cache) Arrays.fill(c, -1);

        return dp(0, 0);
    }

    private int dp(int i, int j){
        if(i < 0 || j < 0 || i == r || j == c) return 10000000;
        if(i == r - 1 && j == c - 1) return grid[i][j];
        if(cache[i][j] != -1) return cache[i][j];
        return cache[i][j] = grid[i][j] + Math.min(dp(i + 1, j), dp(i, j + 1));
    }
}