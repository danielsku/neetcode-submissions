class Solution {
    public int findPeakElement(int[] nums) {
        return bS(nums, 0, nums.length - 1);
    }

    public int bS(int[] nums, int l, int r){
        
        int mid = (l + r)/2;

        boolean left = mid - 1 < 0 || nums[mid - 1] < nums[mid];
        boolean right = mid + 1 == nums.length || nums[mid + 1] < nums[mid];

        if(left && right) return mid;
        if(!left) return bS(nums, l, mid - 1);
        return bS(nums, mid + 1, r);
    }
}