class Solution {
    public int findMin(int[] nums) {
        return bS(nums, 0, nums.length - 1);
    }

    private int bS(int[] nums, int l, int r){
        if(r == l) return nums[l];

        int mid = (l + r)/2;

        if(nums[mid] > nums[r]) return bS(nums, mid + 1, r);
        return bS(nums, l, mid);
    }
}
