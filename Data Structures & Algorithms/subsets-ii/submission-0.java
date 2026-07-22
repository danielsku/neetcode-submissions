class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(new ArrayList<>(), nums, 0);
        return res;
    }

    private void backtrack(List<Integer> curr, int[] nums, int i){
        res.add(new ArrayList<>(curr));

        for(int j = i; j < nums.length; j++){
            if(j > i && nums[j] == nums[j-1]) continue;
            curr.add(nums[j]);
            backtrack(curr, nums, j + 1);
            curr.remove(curr.size() - 1);
        }
    }
}
