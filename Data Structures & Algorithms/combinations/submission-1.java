class Solution {

    List<List<Integer>> res;
    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        backtrack(new ArrayList<>(), n, k, 1);
        return res;
    }
    
    void backtrack(List<Integer> curr, int n, int k, int i){
        if(curr.size() == k){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int j = i; j <= n ; j++){
            curr.add(j);
            backtrack(curr, n, k, j + 1);
            curr.remove(curr.size() - 1);
        }
    }
}