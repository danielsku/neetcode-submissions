class Solution {
    public int evalRPN(String[] tokens) {
        Deque<String> stack = new ArrayDeque<>();

        int first;
        int second;
        for(String s : tokens){
            switch(s){
                case "+":
                    first = Integer.valueOf(stack.pop());
                    second = Integer.valueOf(stack.pop());
                    stack.push(String.valueOf(first + second));
                    break;
                case "-":
                    first = Integer.valueOf(stack.pop());
                    second = Integer.valueOf(stack.pop());
                    stack.push(String.valueOf(second - first));
                    break;
                case "*":
                    first = Integer.valueOf(stack.pop());
                    second = Integer.valueOf(stack.pop());
                    stack.push(String.valueOf(first * second));
                    break;
                case "/":
                    first = Integer.valueOf(stack.pop());
                    second = Integer.valueOf(stack.pop());
                    stack.push(String.valueOf(second/first));
                    break;
                default:
                    stack.push(s);
            }
        }
        return Integer.valueOf(stack.pop());
    }
}
