class Solution {
    int[] nums;
    Integer[][] cache;
    int total;
    public int findTargetSumWays(int[] nums, int target) {
        this.nums = nums;
        int n = nums.length;
        int total = 0;
        for(int k : nums) total += k;
        this.cache = new Integer[nums.length + 1][2*total + 1];
        this.total = total;

        return dp(0, target);  
    }

    private int dp(int i, int t){
        if(Math.abs(t) > total) return 0;

        if(i == nums.length) {
            if(t == 0) return 1;
            else return 0;
        }

        if(cache[i][total + t] != null) return cache[i][total + t];

        return cache[i][total + t]= dp(i + 1, t - nums[i]) + dp(i + 1, t + nums[i]);
    }
}
