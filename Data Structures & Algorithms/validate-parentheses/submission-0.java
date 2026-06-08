class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> match = new HashMap<>();
        Deque<Character> stack = new ArrayDeque<>();
        match.put(')', '(');
        match.put(']', '[');
        match.put('}', '{');

        for(char c : s.toCharArray()){
            if(match.containsKey(c)){
                if(stack.isEmpty()) return false;
                if(stack.pop() != match.get(c)) return false;
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }   
}
