class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> window = new HashMap<>();
        int l = 0, res = 0;
        for(int r = 0; r < s.length(); r++){
            if(window.containsKey(s.charAt(r))){
                l = Math.max(window.get(s.charAt(r)) + 1, l);
            }
            window.put(s.charAt(r), r);
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}

// abcdeabaa
// 123456789