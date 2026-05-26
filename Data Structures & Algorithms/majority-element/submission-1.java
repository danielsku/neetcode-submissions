// O(1) Space solution

class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int current = nums[0];
        for(int i = 0; i<nums.length; i++){
            if(current != nums[i]){
                current = nums[i];
                count = 0;
            }
            count++;
            if(count > Math.floor(nums.length/2)) return current;
        }
        return 0;
    }
}