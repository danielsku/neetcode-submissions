class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        int count[] = new int[26];

        for(char s : s1.toCharArray()){
            count[s - 'a']++;
        }

        int window[] = new int[26];
        for(int r = 0; r < s1.length(); r++){
            window[s2.charAt(r) - 'a']++;
        }

        if(Arrays.equals(count, window)) return true;

        for(int r = s1.length(); r < s2.length(); r++){
            window[s2.charAt(r) - 'a']++;
            window[s2.charAt(r - s1.length()) - 'a']--;
            if(Arrays.equals(count, window)) return true;
        }
        return false;
    }
}
