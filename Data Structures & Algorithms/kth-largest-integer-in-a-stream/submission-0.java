class KthLargest {
    PriorityQueue<Integer> pq;
    int k;

    public KthLargest(int k, int[] nums) {
        this.pq = new PriorityQueue<>(Collections.reverseOrder());
        this.k = k;
        for(int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
        }
    }
    
    public int add(int val) {
        PriorityQueue<Integer> temp = new PriorityQueue<>();
        int kth = 0;
        pq.add(val);
        for(int i = 0; i < k - 1; i++){
            temp.add(pq.poll());
        }
        kth = pq.peek();
        for(int i = 0; i < k - 1; i++){
            pq.add(temp.poll());
        }
        return kth;
    }
}
