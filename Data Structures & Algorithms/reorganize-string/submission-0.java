class Solution {
    public String reorganizeString(String s) {
        int freq[] = new int[26];
        for(char c : s.toCharArray()) freq[c - 'a']++;

        int maxIdx = 0;
        for(int i = 1; i < freq.length; i++)
            if(freq[i] > freq[maxIdx]) maxIdx = i;

        if(freq[maxIdx] > (s.length() + 1)/2) return "";
        
        int idx = 0;
        char maxChar = (char) (maxIdx + 'a');
        char res[] = new char[s.length()];

        while(freq[maxIdx] > 0){
            res[idx] = maxChar;
            freq[maxIdx]--;
            idx+=2;
        }

        for(int i = 0; i < freq.length; i++){
            while(freq[i] > 0){
                if(idx >= res.length) idx = 1;
                res[idx] = (char)(i + 'a');
                freq[i]--;
                idx+=2;
            }
        }

        return new String(res);
    }
}