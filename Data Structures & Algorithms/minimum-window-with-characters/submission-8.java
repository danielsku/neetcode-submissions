class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()) return "";

        Map<Character, Integer> bag = new HashMap<>();
        for(char c : t.toCharArray()){
            bag.put(c , bag.getOrDefault(c, 0) + 1);
        }

        int l = 0;
        int minl = 0, minr = s.length() + 1;
        HashMap<Character, Integer> check = new HashMap<>();
        for(int r = 0; r < s.length(); r++){
            if(bag.containsKey(s.charAt(r))){
                check.put(s.charAt(r) , check.getOrDefault(s.charAt(r), 0) + 1);
            }

            while(atLeast(bag, check)){
                if(bag.containsKey(s.charAt(l))){
                    check.put(s.charAt(l) , check.get(s.charAt(l)) - 1);
                }
                if(minr - minl > r - l){
                    minr = r + 1;
                    minl = l;
                }
                l++;            
            }
        }
        if(minr % (s.length() + 1) == 0) return "";

        StringBuilder minSub = new StringBuilder();
        for(int i = minl; i < minr; i++){
            minSub.append(s.charAt(i));
        }

        return minSub.toString();
    }

    public boolean atLeast(Map<Character, Integer> map1, Map<Character, Integer> map2){
        for(Map.Entry<Character, Integer> entry : map1.entrySet()){
            char key = entry.getKey();
            int required = entry.getValue();

            if (map2.getOrDefault(key, 0) < required) {
                return false;
            }
        }
        return true;
    }
}
