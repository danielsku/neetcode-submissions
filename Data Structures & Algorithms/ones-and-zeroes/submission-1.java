class Solution {
    HashMap<String, int[]> map; 
    String[] strs;
    Integer[][][] cache;
    public int findMaxForm(String[] strs, int m, int n) {
        this.map = new HashMap<>();
        this.strs = strs;
        for(String s : strs) map.put(s, countBits(s));

        this.cache = new Integer[strs.length + 1][m + 1][n + 1];

        return dp(0, m, n);
    }

    private int dp(int i, int m, int n){
        if(cache[i][m][n] != null) return cache[i][m][n];
        
        int max = 0;
        for(int j = i; j < strs.length; j++) {
            int[] count = map.get(strs[i]);
            if(m - count[0] >= 0 && n - count[1] >= 0){
                max = Math.max(max, Math.max(
                    1 + dp(j + 1, m - count[0], n - count[1]),
                    dp(j + 1, m, n)
                    )
                );
            } else {
                max = Math.max(max, dp(j + 1, m, n));
            }
            
        }

        return cache[i][m][n] = max;

    }

    private int[] countBits(String b){
        int[] count = new int[]{0, 0};
        for(char c : b.toCharArray())
            count[c -'0']++;

        return count;
    }

}