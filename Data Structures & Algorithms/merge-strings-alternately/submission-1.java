// More optimal


class Solution {
    public String mergeAlternately(String word1, String word2) {
        int p2 = 0;
        int p1 = 0;

        StringBuilder sol = new StringBuilder();
        while(p1 < word1.length() && p2 < word2.length()){
            sol.append(word1.charAt(p1++));
            sol.append(word2.charAt(p2++));
        }

        sol.append(word1.substring(p1));

        sol.append(word2.substring(p2));
        

        return sol.toString();
    }
}