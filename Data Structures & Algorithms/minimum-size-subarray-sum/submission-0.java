class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int res = nums.length;
        int total = 0;
        int cur = 0;
        int l = 0;
        for(int r = 0; r < nums.length; r++){
            total+=nums[r];
            cur+=nums[r];
            while(cur >= target){
                res = Math.min(res, r - l + 1);
                cur -= nums[l++];
            }
        }
        if(total < target){
            return 0;
        }
        return res;
    }
}