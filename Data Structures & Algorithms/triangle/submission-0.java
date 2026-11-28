class Solution {
    Integer cache[][];
    List<List<Integer>> triangle;
    public int minimumTotal(List<List<Integer>> triangle) {
        this.triangle = triangle;
        this.cache = new Integer[triangle.size() + 1][triangle.size() + 1];
        return dp(0, 0);
    }

    private int dp(int r, int i){
        if(r == triangle.size()) return 0;
        if(cache[r][i] != null) return cache[r][i];

        return cache[r][i] = triangle.get(r).get(i) + Math.min(dp(r + 1, i), dp(r + 1, i + 1));
    }
}