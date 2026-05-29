class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int m = -1;
        int ans = -1;

        while(l <= r){
            m = (l+r)/2;
            System.out.println(m);
            if(target<nums[m]){
                r = m - 1;
                ans = m;
            }else if(nums[m]<target){
                l = m + 1;
                ans = l;
            }else{
                return m;
            }
        }
        return ans;
    }
}