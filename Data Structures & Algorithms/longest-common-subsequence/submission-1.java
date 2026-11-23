class Solution {
    String text1, text2;
    int m, n;
    int[][] cache;
    public int longestCommonSubsequence(String text1, String text2) {
        this.m = text1.length();
        this.n = text2.length();
        this.text1 = text1;
        this.text2 = text2;
        this.cache = new int[m][n];
        for(int[] c : cache) Arrays.fill(c, -1);

        return dp(0, 0);
    }

    public int dp(int i, int j){
        if(i == m || j == n) return 0;
        if(cache[i][j] != -1) return cache[i][j];
        if(text1.charAt(i) == text2.charAt(j)) 
            return cache[i][j] = 1 + dp(i + 1, j + 1);
        
        return cache[i][j] = Math.max(dp(i + 1, j), dp(i, j + 1));
    }
}
