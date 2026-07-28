class Solution {
    HashMap<Character, char[]> map;
    List<String> res;
    String digits;
    public List<String> letterCombinations(String digits) {
        this.map = new HashMap<>();
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});

        this.digits = digits;
        this.res = new ArrayList<>();
        
        if(digits.length() == 0) return new ArrayList<>();

        backtrack(0, new StringBuilder());
        return res;
    }

    private void backtrack(int i, StringBuilder curr){
        if(curr.length() == digits.length()){
            res.add(new String(curr));
            return;
        }

        for(int j = i; j < digits.length(); j++){
            char[] arr = map.get(digits.charAt(j));
            for(char c : arr){
                curr.append(c);
                backtrack(j + 1, curr);
                curr.deleteCharAt(curr.length() - 1);
            }
        }
    }
}
