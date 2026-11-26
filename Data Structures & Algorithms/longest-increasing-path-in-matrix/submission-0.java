class Solution {
    int[][] matrix;
    int[][] cache;
    int m, n;
    public int longestIncreasingPath(int[][] matrix) {
        this.matrix = matrix;
        this.m = matrix.length;
        this.n = matrix[0].length;

        this.cache = new int[m][n];
        for(int[] c : cache) Arrays.fill(c, -1);

        int max = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
               max = Math.max(max, 1 + dfs(i, j));
            }
        }

        return max;
    }

    private int dfs(int i, int j){

        if(cache[i][j] != -1) return cache[i][j];

        int max = 0;
        if(i - 1 >= 0 && matrix[i][j] < matrix[i - 1][j]) 
            max = Math.max(max, 1 + dfs(i - 1, j));

        if(i + 1 < m && matrix[i][j] < matrix[i + 1][j]) 
            max = Math.max(max, 1 + dfs(i + 1, j));

        if(j - 1 >= 0 && matrix[i][j] < matrix[i][j - 1]) 
            max = Math.max(max, 1 + dfs(i, j - 1));

        if(j + 1 < n && matrix[i][j] < matrix[i][j + 1]) 
            max = Math.max(max, 1 + dfs(i, j + 1));

        cache[i][j] = max;

        return max;
    }
}
