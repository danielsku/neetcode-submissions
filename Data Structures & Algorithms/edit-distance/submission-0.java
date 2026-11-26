class Solution {
    int l1, l2;
    String w1, w2;
    int cache[][];
    public int minDistance(String word1, String word2) {
        this.l1 = word1.length();
        this.l2 = word2.length();
        this.w1 = word1;
        this.w2 = word2;

        this.cache = new int[l1 + 1][l2 + 1];
        for(int[] c : cache) Arrays.fill(c, -1);

        return dp(0, 0);
    }

    private int dp(int i, int j){
        if(i == l1) return l2 - j;
        if(j == l2) return l1 - i;

        if(cache[i][j] != -1) return cache[i][j];  

        int minWays = 0;
        if(w1.charAt(i) == w2.charAt(j))
            minWays = dp(i + 1, j + 1);
        else {
            minWays = Math.min(
                1 + dp(i + 1, j), 
                Math.min(1 + dp(i, j + 1), 1 + dp(i + 1, j + 1)));
        }

        return cache[i][j] = minWays;
    }
}
