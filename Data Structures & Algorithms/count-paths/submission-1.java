class Solution {
    int cache[][];
    public int uniquePaths(int m, int n) {
        this.cache = new int[m][n];
        for(int[] c : cache) Arrays.fill(c, -1);

        return dp(m - 1, n - 1);
    }

    private int dp(int i, int j){
        if(i < 0 || j < 0) return 0;
        if(j == 0 && i == 0) return 1;
        if(cache[i][j] != -1) return cache[i][j];
        return cache[i][j] = dp(i - 1, j) + dp(i, j - 1);
    }
}
