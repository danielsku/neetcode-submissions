class Solution {
    public String decodeString(String s) {
        Deque<String> stack = new ArrayDeque<>();
        Deque<Integer> count = new ArrayDeque<>();

        int k = 0;
        StringBuilder curr = new StringBuilder();

        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                k = 10 * k + (c - '0');
            }else if(c == '['){
                count.push(k);
                stack.push(curr.toString());
                k = 0;
                curr = new StringBuilder();
            }else if(c == ']'){
                String temp = curr.toString();
                int num = count.pop();
                curr = new StringBuilder(stack.pop());
                for(int i = 0; i < num; i++){
                    curr.append(temp);
                }
            }else{
                curr.append(c);
            }
        }

        return curr.toString();
    }
}