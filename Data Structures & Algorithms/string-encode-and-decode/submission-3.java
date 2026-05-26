// Resolve this problem on a future date

class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs){
            sb.append(s.length());
            sb.append("#");
            sb.append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        System.out.println(str + '\n');

        List<String> ds = new ArrayList<>();
        
        char[] decomp = str.toCharArray();
        StringBuilder current = new StringBuilder();
        for(int i = 0; i<decomp.length; i++){
            int count = 0;
            while(decomp[i] != '#'){
                count = count * 10 + (decomp[i] - '0');
                i++;
            }
            i++;
            System.out.println(count);
            
            System.out.print("");
            for(int j = 0; j<count; j++, i++){
                System.out.print(decomp[i]);
                current.append(decomp[i]);
            }
            i--;
            ds.add(current.toString());
            current = new StringBuilder();
        }

        return ds;
    }
}
