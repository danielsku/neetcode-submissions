class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int pair[][] = new int[position.length][2];
        for(int i = 0; i < position.length; i++){
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }
        Arrays.sort(pair, (a,b) -> Integer.compare(a[0], b[0]));

        Deque<int[]> stack = new ArrayDeque<>();
        int fleet = 0;
        for(int i = position.length - 1; i >= 0; i--){
            double time = (double)(target - pair[i][0])/(double) pair[i][1];
            while(!stack.isEmpty() && time > (double)(target - stack.peek()[0])/(double) stack.peek()[1]){
                stack.pop();
            }
            if(stack.isEmpty()) fleet++;
            stack.push(pair[i]);
        }
        return fleet;
    }
}
