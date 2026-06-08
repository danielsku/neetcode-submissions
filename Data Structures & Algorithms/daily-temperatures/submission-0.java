class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<int[]> stack = new ArrayDeque<>();
        int answer[] = new int[temperatures.length];
        int pair[];

        for(int i = 0; i < temperatures.length; i++){
            while(!stack.isEmpty() && temperatures[i] > stack.peek()[0]){
                pair = stack.pop();
                answer[pair[1]] = i - pair[1];
            }
            stack.push(new int[]{temperatures[i], i});
        }

        return answer;
    
    }
}
