class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        backtrack(nums, 0);
        return res;
    }

    void backtrack(int nums[], int i){
        if(i == nums.length){
            List<Integer> perm = new ArrayList<>();
            for(int num : nums) perm.add(num);
            res.add(perm);
            return;
        }

        for(int j = i; j < nums.length; j++){
            swap(nums, i, j);
            backtrack(nums, i + 1);
            swap(nums, i, j);
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
