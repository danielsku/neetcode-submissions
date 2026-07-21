class Solution {
    
    int result = 0;

    public int subsetXORSum(int[] nums) {
        backtrack(0, nums, new ArrayList<>());
        return result;
    }

    void backtrack(int i, int[] nums, List<Integer> subset){
        int xorr = 0;

        for(int num : subset) xorr ^= num;
        result += xorr;

        for(int j = i; j < nums.length; j++){
            subset.add(nums[j]);
            backtrack(j + 1, nums, subset);
            subset.remove(subset.size() - 1);
        }
        
    }
}