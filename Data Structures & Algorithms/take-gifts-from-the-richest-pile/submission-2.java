class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>((a, b) -> Long.compare(b, a));
        for(int gift : gifts) pq.offer((long)gift);

        while(k > 0){
            pq.offer((long) Math.floor(Math.sqrt(pq.poll())));
            k--;
        }

        long total = 0;
        while(!pq.isEmpty()){
            total += pq.poll();
        }

        return total;
    }
}