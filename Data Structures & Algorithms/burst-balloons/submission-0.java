class Solution {
    int[] N;
    int cache[][];
    public int maxCoins(int[] nums) {
        int n = nums.length;
        this.N = new int[n + 2];
        N[0] = N[n + 1] = 1;
        for(int i = 0; i < n; i++) N[i + 1] = nums[i];
        this.cache = new int[n + 1][n + 1];
        for(int[] c : cache) Arrays.fill(c, -1);
        return dp(1, n);
    }

    private int dp(int l, int r){
        if(r < l) return 0;
        if(cache[l][r] != -1) return cache[l][r];
        for(int i = l; i <= r; i++){
            cache[l][r] = Math.max(cache[l][r], N[l - 1]*N[i]*N[r + 1] + dp(l, i - 1) + dp(i + 1, r));
        }
        return cache[l][r];
    }
}
