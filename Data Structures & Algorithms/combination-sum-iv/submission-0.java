class Solution {
    int[] nums;
    int[][] cache;
    public int combinationSum4(int[] nums, int target) {
        this.nums = nums;
        this.cache = new int[nums.length + 1][target + 1];
        for(int[] c : cache) Arrays.fill(c , -1);

        return dp(0, target);
    }

    public int dp(int i, int t){
        if(t == 0) return 1;
        if(i == nums.length || t < 0) return 0;

        if(cache[i][t] != -1) return cache[i][t];
        
        int ways = 0;
        for(int j = 0; j < nums.length; j++){
            ways += dp(j, t - nums[j]);
        }

        return cache[i][t] = ways;
    }
}