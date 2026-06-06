class Solution {
    public int firstMissingPositive(int[] nums) {
        int a = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == a + 1){
                int temp = nums[a];
                nums[a] = nums[i];
                nums[i] = temp;
                i = a;
                a++;
            }
        }
        return a + 1;
    }
}