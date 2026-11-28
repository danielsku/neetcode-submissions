class Solution {
    String s, p; 
    int l1, l2;
    Boolean cache[][];
    public boolean isMatch(String s, String p) {
        this.s = s;
        this.p = p;
        this.l1 = s.length();
        this.l2 = p.length();
        this.cache = new Boolean[l1 + 1][l2 + 1];

        return dp(0, 0);
    }

    private boolean dp(int i, int j){
        // if(i == l1 && j == l2) return true;
        // if(i == l1 || j == l2) return false;

        if(j == l2) return i == l1;


        if(cache[i][j] != null) return cache[i][j];

        boolean match = i < l1 && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        if(j < l2 - 1 && p.charAt(j + 1) == '*')
            return cache[i][j] = dp(i, j + 2) || match && dp(i + 1, j);
        else return cache[i][j] = match && dp(i + 1, j + 1);

    }
}
