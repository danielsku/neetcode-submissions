class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int stone : stones){
            pq.offer(stone);
        }

        while(pq.size() != 1){
            int stone1 = pq.poll();
            int stone2 = pq.poll();
            int biggest = Math.abs(stone1 - stone2);
            pq.offer(biggest);
        }

        return pq.poll();
        
    }
}
