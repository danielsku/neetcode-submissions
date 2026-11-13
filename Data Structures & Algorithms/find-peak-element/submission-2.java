class Solution {
    public int findPeakElement(int[] nums) {
        return bS(nums, 0, nums.length - 1);
    }

    public int bS(int[] nums, int l, int r){
        if(l == r) return l;

        int m = (l + r)/2;

        if(nums[m] > nums[m + 1]){
            return bS(nums, l, m);
        }
        return bS(nums, m + 1, r);
    }
}