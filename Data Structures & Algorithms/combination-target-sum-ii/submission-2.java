class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(new ArrayList<>(), candidates, target, 0);
        return res;
    }

    void backtrack(List<Integer> curr, int[] candidates, int total, int i){

        if(total == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int j = i; j < candidates.length; j++){
            if (j > i && candidates[j] == candidates[j - 1]) {
                continue;
            }
            if(total - candidates[j] < 0){
                break;
            }

            curr.add(candidates[j]);
            backtrack(curr, candidates, total - candidates[j], j + 1);
            curr.remove(curr.size() - 1);
        }
    }
}
