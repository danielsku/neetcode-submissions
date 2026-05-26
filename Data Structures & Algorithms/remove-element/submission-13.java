// Redo at some point in the future

class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i] != val){
                nums[k++] = nums[i];
            }
        }

        return k;

    }
}