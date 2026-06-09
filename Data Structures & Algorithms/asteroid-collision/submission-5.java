// Resolve
// **********************
// **********************
// **********************

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(int a : asteroids){
            while(!stack.isEmpty() && a < 0 && stack.peek() > 0){
                int diff = a + stack.peek();
                if(diff < 0){
                    stack.pop();
                } else if(diff > 0){
                    a = 0;
                } else{
                    a = 0;
                    stack.pop();
                }
            }
            if(a != 0){
                stack.push(a);
            }
        }
        int ans[] = new int[stack.size()];
        int j = stack.size() - 1;
        while(!stack.isEmpty()){
            ans[j--] = stack.pop();
        }
        return ans;
    }
}