class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        String[] decomp = path.split("/");

        for(String c : decomp){
            if(c.equals("..")){
                if(!stack.isEmpty()) stack.pop();
            }else if(!c.equals("") && !c.equals(".")){
                stack.push(c);
            }
        }
        Deque<String> restack = new ArrayDeque();
        while(!stack.isEmpty()){
            restack.push(stack.pop());
        }
        
        StringBuilder rejoin = new StringBuilder();
        while(!restack.isEmpty()){
            rejoin.append("/");
            rejoin.append(restack.pop());
        }
        if(rejoin.length() == 0){
            rejoin.append("/");
        }
        return rejoin.toString();
    }
}