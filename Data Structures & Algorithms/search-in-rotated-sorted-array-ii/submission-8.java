class Solution {
    public boolean search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while(l <= r){
            int m = l + (r - l)/2;
            System.out.println(nums[m] + " " + m);
            if(nums[m] == target){
                return true;
            }else if(nums[l] == nums[m] && nums[m] == nums[r]){
                l++;
                r--;
            }
            else if(nums[m] > nums[r] && (nums[m] < target || target <= nums[r])){
                l = m + 1;
            }else if(nums[m] < nums[l] && (nums[l] <= target || target < nums[m])){
                r = m - 1;
            }else if(nums[m] < target){
                l = m + 1;
            }else if(target < nums[m]){
                r = m - 1;
            }
        }

        

        return false;
    }
}