class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int[]> minCap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> maxPro = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        for(int i = 0; i < profits.length; i++){
            minCap.add(new int[]{capital[i], profits[i]});
        }

        int idx = 0, currW = w;
        while(idx < k){
            while(!minCap.isEmpty() && minCap.peek()[0] <= currW) maxPro.offer(minCap.poll());

            if(maxPro.isEmpty()) break;

            currW += maxPro.poll()[1];
            idx++;
        }

        return currW;
    }
}