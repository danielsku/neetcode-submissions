class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), nums, 0);
        return res;
    }

    void backtrack(
        List<List<Integer>> res, 
        List<Integer> subset, int[] nums, int i ) {

            res.add(new ArrayList(subset));

            for(int j = i; j < nums.length; j++){
                subset.add(nums[j]);
                while(j > i && nums[j] == nums[j-1]) continue;
                backtrack(res, subset, nums, j+1);
                subset.remove(subset.size() - 1);
            }
        }
}
