class Solution {
    int cache[];
    int nums[];
    public int lengthOfLIS(int[] nums) {
        this.nums = nums;

        int n = nums.length;
        this.cache = new int[n];
        Arrays.fill(cache, -1);

        int max = 1;
        for(int i = 0; i < n; i++){
            max = Math.max(max, dp(i));
        }
        return max;
    }

    private int dp(int i){
        if(cache[i] != -1) return cache[i];

        int LIS = 1;
        for(int j = i + 1; j < nums.length; j++){
            if(nums[i] < nums[j])
                LIS = Math.max(LIS, 1 + dp(j)); 
        }

        cache[i] = LIS;
        return LIS;
    }
}
