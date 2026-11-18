class Solution {

    HashSet<String> set;
    int maxLength;
    String s;
    Boolean cache[];

    public boolean wordBreak(String s, List<String> wordDict) {
        this.s = s;
        this.set = new HashSet<>();
        this.cache = new Boolean[s.length() + 1];

        this.maxLength = 0;
        for(String w : wordDict) {
            set.add(w);
            maxLength = Math.max(maxLength, w.length());
        }

        return dp(0);
    }

    private boolean dp(int i){
        if(i == s.length()) return true;

        if(cache[i] != null) return cache[i];

        for(int j = i; j < Math.min(i + maxLength, s.length()); j++){
            if(set.contains(s.substring(i, j + 1))){
                if(dp(j + 1)){
                    cache[i] = true;
                    return true;
                }
            }
        }
        cache[i] = false;
        return false;
    }
}
