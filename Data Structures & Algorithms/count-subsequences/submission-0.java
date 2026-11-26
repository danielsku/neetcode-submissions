class Solution {
    int l, l2;
    String s, t;
    int[][] cache;
    public int numDistinct(String s, String t) {
        this.l = t.length();
        this.l2 = s.length();
        this.s = s;
        this.t = t;    

        this.cache = new int[l2 + 1][l + 1];
        for(int[] c : cache) Arrays.fill(c, -1);    

        return dp(0, 0);
    }


    private int dp(int i, int j){
        if(j == l) return 1;
        if(i == l2) return 0;

        if(cache[i][j] != -1) return cache[i][j]; 

        int numWays = 0;
        if(s.charAt(i) == t.charAt(j))
            numWays += dp(i + 1, j + 1) + dp(i + 1 , j);
        else 
            numWays += dp(i + 1, j);
    
        return cache[i][j] = numWays;
    }
}
