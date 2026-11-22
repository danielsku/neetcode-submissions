class Solution {
    Boolean cache[][];
    int nums[];
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums) sum += num;
        if(sum % 2 != 0) return false;
            
        int t = sum / 2;
        this.nums = nums;
        this.cache = new Boolean[nums.length][t + 1];
        return dp(0, t);
    }

    private boolean dp(int i, int t){
        if(t == 0) return true;
        if(t < 0 || i == nums.length) return false;
        if(cache[i][t] != null) return cache[i][t];
        boolean a = dp(i + 1, t) || dp(i + 1, t - nums[i]);
        cache[i][t] = a;
        return a;
    }
}
