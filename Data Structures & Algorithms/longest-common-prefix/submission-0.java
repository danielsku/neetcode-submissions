class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs, Comparator.comparingInt(s -> s.length()));
        List<Character> prefix = new ArrayList<>();
        char[] shortest = strs[0].toCharArray();
        outer:
        for(int i = 0; i<shortest.length;i++){
            for(String str : strs){
                if(str.charAt(i) != shortest[i]){
                    break outer;
                }
            }
            prefix.add(shortest[i]);
        }

        StringBuilder sb = new StringBuilder();
        for(char c : prefix){
            sb.append(c);
        }

        return String.valueOf(sb);
        
    }
}