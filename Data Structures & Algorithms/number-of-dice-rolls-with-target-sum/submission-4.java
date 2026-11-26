class Solution {
    int k;
    int target;
    Integer cache[][][];
    public int numRollsToTarget(int n, int k, int target) {
        this.k = k;
        this.target = target;
        this.cache = new Integer[k + 1][n + 1][target + 1];

        return dp(1, n, target);
    }

    private int dp(int i, int n, int t){
        if(t < 0) return 0;
        if(n == 0) return t == 0 ? 1 : 0;
        if(cache[i][n][t] != null) return cache[i][n][t];

        int nWays = 0;
        for(int j = 1; j <= k; j++){
            nWays = (nWays + dp(j, n - 1, t - j)) % 1_000_000_007;
        }
        return cache[i][n][t] = nWays;
    }
}
