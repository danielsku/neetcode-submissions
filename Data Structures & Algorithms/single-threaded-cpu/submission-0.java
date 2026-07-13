// Resolve
//////////

class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[] res = new int[n];
        int[][] arr = new int[n][3];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            if(a[1] != b[1]) return a[1] - b[1];
            else return a[2] - b[2];
        });

        for(int i = 0; i < n; i++){
            arr[i] = new int[]{tasks[i][0], tasks[i][1], i};
        }

        Arrays.sort(arr, (a,b) -> a[0] - b[0]);

        int idx = 0, i = 0, time = 0;

        while(i < n || !pq.isEmpty()){
            if(pq.isEmpty() && time < arr[i][0]) time = arr[i][0];
            while(i < n && arr[i][0] <= time) pq.offer(arr[i++]);
            
            res[idx++] = pq.peek()[2];
            time += pq.poll()[1];
            
        }

        return res;
    }
}