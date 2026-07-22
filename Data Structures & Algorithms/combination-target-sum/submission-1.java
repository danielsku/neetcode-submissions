class Solution {
    List<List<Integer>> res;
    int target;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        this.target = target;
        this.res = new ArrayList<>();
        Arrays.sort(nums);

        dfs(0, new ArrayList<>(), 0, nums);
        return res;
    }

    void dfs(int i, List<Integer> cur, int total, int[] nums){
        if(total == target){
            res.add(new ArrayList<>(cur));
            return;
        }

        for(int j = i; j < nums.length; j++){
            if(total + nums[j] > target) return;
            cur.add(nums[j]);
            dfs(j, cur, total + nums[j], nums);
            cur.remove(cur.size() - 1);
        }
    }
}
