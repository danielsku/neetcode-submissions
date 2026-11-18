class Solution {

    String s;
    HashMap<Integer, Integer> dp ;

    public int numDecodings(String s) {
        dp = new HashMap<>();
        dp.put(s.length(), 1);
        this.s = s;
        return dp(0);
    }

    public int dp(int i){
        if(dp.containsKey(i)) return dp.get(i);
        if(s.charAt(i) == '0') return 0;
        char n = s.charAt(i);
        int res = dp(i + 1);
        if(i + 1 < s.length() && (s.charAt(i) == '1' 
        || s.charAt(i) == '2' && s.charAt(i + 1) < '7'))
            res+=dp(i+2);

        dp.put(i, res);
        return res; 
    }
}


