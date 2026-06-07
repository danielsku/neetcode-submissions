class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> numbers = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int r = 0; r < k; r++){ 
            pq.add(nums[r]);  
        }
        numbers.add(pq.peek());

        for(int r = k; r < nums.length; r++){
            pq.remove(nums[r - k]);
            pq.add(nums[r]);
            numbers.add(pq.peek());
        }

        int ans[] = new int[numbers.size()];
        for(int i = 0; i < numbers.size(); i++){
            ans[i] = numbers.get(i);
        }
        return ans;
    }
}
