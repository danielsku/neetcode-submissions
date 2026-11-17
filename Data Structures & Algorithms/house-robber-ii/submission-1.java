class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int n = nums.length;
        int[] cache = new int[n];
        Arrays.fill(cache, -1);
        int[] cache1 = new int[n];
        Arrays.fill(cache1, -1);
        return Math.max(dp(0, n - 1, nums, cache), dp(1, n, nums, cache1));
    }

    private int dp(int i, int n, int[] nums, int[] cache){
        if(i >= n) return 0;
        if(cache[i] != -1) return cache[i];
        return cache[i] = Math.max(nums[i] + dp(i + 2, n, nums, cache), dp(i + 1, n, nums, cache));
    }
}
