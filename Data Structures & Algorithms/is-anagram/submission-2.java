class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        Map<Character, Integer> a = new HashMap<>();
        
        for(char x : s.toCharArray()){
            a.put(x, a.getOrDefault(x, 0) + 1);
        }

        for(char x : t.toCharArray()){
            a.put(x, a.getOrDefault(x, 0) - 1);
        }

        for(Map.Entry<Character, Integer> entry : a.entrySet()) {
            if(entry.getValue() != 0) return false;
        }
        
        return true;
    }
}
