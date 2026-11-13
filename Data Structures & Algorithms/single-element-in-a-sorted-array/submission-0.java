class Solution {
    public int singleNonDuplicate(int[] nums) {
        return binarySearch(nums, 0, nums.length - 1);
    }

    public int binarySearch(int[] nums, int l, int r){
        if(r == l) return nums[r];

        int mid = (l + r)/2;
        
        if(nums[mid + 1] == nums[mid]){
            if((r - mid + 1) % 2 == 1) return binarySearch(nums, mid + 2, r);
            return binarySearch(nums, l, mid - 1);
        }
        
        if(nums[mid - 1] == nums[mid]){
            if((r - mid + 1) % 2 == 1) return binarySearch(nums, l, mid - 2);
            return binarySearch(nums, mid + 1, r);
        }

        return nums[mid];
    
    }
}