class Solution {
    List<List<String>> res;
    String s;
    public List<List<String>> partition(String s) {
        this.res = new ArrayList<>();
        this.s = s;
        backtrack(0, new ArrayList<>());
        return res;
    }

    void backtrack(int i, List<String> part){
        if(i >= s.length()){
            res.add(new ArrayList<>(part));
            return;
        }

        for(int j = i; j < s.length(); j++){
            if(isPalindrome(s, i, j)){
                part.add(s.substring(i, j + 1));
                backtrack(j + 1, part);
                part.remove(part.size() - 1);
            }
        }
    }

    boolean isPalindrome(String s, int l, int r){
        while(l < r){
            if(s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }
}
