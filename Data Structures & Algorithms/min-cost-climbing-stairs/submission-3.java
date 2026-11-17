class Solution {

    int cache[];
    public int minCostClimbingStairs(int[] cost) {
        cache = new int[cost.length];
        Arrays.fill(cache, -1);
        return Math.min(dp(0, cost), dp(1, cost));
    }

    public int dp(int i, int[] cost){
        if(i >= cost.length) return 0;
        if(cache[i] != -1) return cache[i];

        return cache[i] = cost[i] + Math.min(dp(i + 1, cost), dp(i + 2, cost));
    }
}
