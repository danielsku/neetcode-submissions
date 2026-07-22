class Solution {
    int target;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        this.target = target;
        HashSet<List<Integer>> temp = new HashSet<>();
        backtrack(temp, new ArrayList<>(), nums, 0);
        return new ArrayList<>(temp);
    }

    void backtrack(HashSet<List<Integer>> res, List<Integer> comb, int[] nums, int i) {

        int sum = 0;
        for(int num : comb) sum += num;
        if(sum == target) res.add(new ArrayList<>(comb));
        if(sum > target) return;

        for(int j = i; j < nums.length; j++){
            comb.add(nums[j]);
            backtrack(res, comb, nums, j);
            backtrack(res, comb, nums, j+1);
            comb.remove(comb.size() - 1);
        }

    }
}
