class Solution {
    String s1, s2, s3;
    Boolean cache[][];
    public boolean isInterleave(String s1, String s2, String s3) {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        this.cache = new Boolean[s1.length() + 1][s2.length() + 1];
        return dp(0, 0, 0);
    }

    private boolean dp(int i, int j, int k){
        if(k == s3.length()){
            if(i == s1.length() && j == s2.length()) return true;
            else return false;
        }
        if(cache[i][j] != null) return cache[i][j];

        if(i < s1.length() && s1.charAt(i) == s3.charAt(k)){
            if(dp(i + 1, j, k + 1)) return cache[i][j] = true;
        }

        if(j < s2.length() && s2.charAt(j) == s3.charAt(k)){
            if(dp(i, j + 1, k + 1)) return cache[i][j] = true;
        }

        return cache[i][j] = false;
    }
}
