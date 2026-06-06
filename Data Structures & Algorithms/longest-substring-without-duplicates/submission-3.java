class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> window = new HashSet<>();
        // a, b, c, b
        int l = 0;
        int max = 0;
        int cur = 0;
        for(int r = 0; r < s.length(); r++){
            while(window.contains(s.charAt(r))) {
                window.remove(s.charAt(l));
                l++;
                cur--;
            }
            window.add(s.charAt(r));
            cur++;
            max = Math.max(max, cur);
        }


        return max;
    }
}
