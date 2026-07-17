class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int[]> minCap = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        PriorityQueue<int[]> maxProfits = new PriorityQueue<>((a, b) -> (b[0] - a[0]));

        for(int i = 0; i < profits.length; i++) minCap.offer(new int[]{profits[i], capital[i]});

        int idx = 0, currW = w;
        while(idx < k){
            while(!minCap.isEmpty() && minCap.peek()[1] <= currW) maxProfits.offer(minCap.poll());
            
            if (maxProfits.isEmpty()) {
                break;
            }
        
            currW += maxProfits.poll()[0];   
            idx++;
        }

        return currW;
    }
}