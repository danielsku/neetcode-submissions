class Solution {
    public int calPoints(String[] operations) {
        Deque<String> stack = new ArrayDeque<>();
        for(String s : operations){
            if(s.equals("+")){
                Iterator<String> it = stack.iterator();
                int first = Integer.valueOf(it.next());
                int second = Integer.valueOf(it.next());
                stack.push(String.valueOf(first + second));
            }else if(s.equals("D")){
                stack.push(String.valueOf(Integer.valueOf(stack.peek())*2));
            }else if(s.equals("C")){
                stack.pop();
            }else{
                stack.push(s);
            }
        }

        int total = 0;
        while(!stack.isEmpty()){
            total += Integer.valueOf(stack.pop());
        }
        return total;
    }
}