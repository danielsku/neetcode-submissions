class FreqStack {

    Deque<int[]> stack;
    HashMap<Integer, Integer> map;
    int mostFreq;
    int prevMost;

    public FreqStack() {
        stack = new ArrayDeque<>();
        map = new HashMap<>();
    }
    
    public void push(int val) {
        map.put(val, map.getOrDefault(val, 0) + 1);

        if(stack.isEmpty() || map.get(val) >= mostFreq){
            prevMost = mostFreq;
            mostFreq = map.get(val);
        }

        stack.push(new int[]{val, map.get(val), prevMost});
    }
    
    public int pop() {
        Deque<int[]> putback = new ArrayDeque<>();
        
        while(stack.peek()[1] != mostFreq){
            putback.push(stack.pop());
        }

        map.put(stack.peek()[0], map.getOrDefault(stack.peek()[0], 0) - 1);
        
        int toRet = stack.peek()[0];

        mostFreq = stack.pop()[2];

        while(!putback.isEmpty()){
            stack.push(putback.pop());
        }
        return toRet;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */