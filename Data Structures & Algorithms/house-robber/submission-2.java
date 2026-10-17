class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);
        
        int r[] = new int[n];
        r[0] = nums[0];
        r[1] = Math.max(nums[0], nums[1]);

        for(int i = 2; i < n; i++){
            r[i] = Math.max(r[i - 1], nums[i] + r[i - 2]);
        }

        return r[n - 1];
    }
}
