class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtrack(new ArrayList<>(), nums, visited);
        return res;
    }

    void backtrack(List<Integer> cur, int[] nums, boolean[] visited){
        
        if(cur.size() == nums.length){
            res.add(new ArrayList<>(cur));
            return;
        }

        for(int j = 0; j < nums.length; j++){
            if(visited[j]) continue;
            cur.add(nums[j]);
            visited[j] = true;
            backtrack(cur, nums, visited);
            visited[j] = false;
            cur.remove(cur.size() - 1);
        }
    }
}
