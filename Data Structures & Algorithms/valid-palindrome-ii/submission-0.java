class Solution {
    public boolean validPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while(l < r){
            if(s.charAt(l) != s.charAt(r)){
                return checkPalindrome(l + 1, r, s) || checkPalindrome(l, r - 1, s);
            }
            l++;
            r--;
        }
        return true;
    }

    public boolean checkPalindrome(int l, int r, String s){
        while(l < r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}