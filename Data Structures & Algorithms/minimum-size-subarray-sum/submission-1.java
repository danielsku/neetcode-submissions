class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int cur = 0;
        int l = 0;
        for(int r = 0; r < nums.length; r++){
            cur+=nums[r];
            while(cur >= target){
                res = Math.min(res, r - l + 1);
                cur -= nums[l++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}