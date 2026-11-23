class Solution {
    int[] coins;
    int[][] cache;
    public int change(int amount, int[] coins) {
        this.coins = coins;
        this.cache = new int[coins.length + 1][amount + 1];
        for(int[] c : cache) Arrays.fill(c, -1);

        int unique = 0;
        return dp(0, amount);
    }

    private int dp(int i, int amount){
        if(amount < 0 || i >= coins.length) return 0;
        if(amount == 0) return 1;
        if(cache[i][amount] != -1) return cache[i][amount];

        int res = 0;
        if(amount >= coins[i]){
            res = dp(i + 1, amount) + dp(i, amount - coins[i]);
        } else{
            res = dp(i + 1, amount);
        }
        
        return cache[i][amount] = res;
    }
}
