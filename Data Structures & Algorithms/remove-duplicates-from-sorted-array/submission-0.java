class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 1;
        int p2 = 1;
        while(p2 < nums.length){
            if(nums[p2] != nums[k-1]){
                nums[k++] = nums[p2];
            }
            p2++;
        }
        return k;
    }
}