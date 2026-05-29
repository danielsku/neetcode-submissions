class Solution {
    public int search(int[] nums, int target) {
        int size = nums.length - 1;
        
        int l = 0;
        int r = size;
        int m = 0;

        while(l <= r){
            m = (l+r)/2;
            if(nums[m] == target) return m;
            else if(nums[m] > nums[r] && (nums[m]<target || target <= nums[r])){
                l = m + 1;
            }else if(nums[m] < nums[l] && (nums[l]<=target || target < nums[m])){
                r = m - 1;
            }else if(target > nums[m]){
                l = m + 1;
            }else if(target < nums[m]){
                r = m - 1;
            }
        }
        return -1;
    }
}
