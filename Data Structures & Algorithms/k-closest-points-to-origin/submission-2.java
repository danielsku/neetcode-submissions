class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            int distA = a[0] * a[0] + a[1]*a[1];
            int distB = b[0] * b[0] + b[1]*b[1];
            return Integer.compare(distB, distA);
        });
    
        for(int[] coor : points){
            pq.offer(coor);
            if(pq.size() > k){
                pq.poll();
            }
        }
        
        int[][] ans = new int[k][2];
        for(int i = 0; i < k; i++){
            int[] curr = pq.poll();
            ans[i][0] = curr[0];
            ans[i][1] = curr[1];
        }

        return ans;

    }
}
