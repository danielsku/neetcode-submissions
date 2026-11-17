class Solution {
    int[] cache;
    public int rob(int[] nums) {
        cache = new int[nums.length];
        Arrays.fill(cache, -1);
        return Math.max(dp(0, nums), dp(1, nums));
    }

    public int dp(int i, int[] nums) {
        if(i >= nums.length) return 0;
        if(cache[i] != -1) return cache[i];
        return cache[i] = Math.max(nums[i] + dp(i + 2, nums), dp(i + 1, nums));
    }
}
