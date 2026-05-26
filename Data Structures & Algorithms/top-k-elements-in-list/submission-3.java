// Solution with BucketSort

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>();
        List<Integer>[] freq = new List[nums.length + 1];

        for(int i = 0; i<freq.length; i++){
            freq[i] = new ArrayList<>();
        }

        for(int num : nums){
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : counter.entrySet()){
            freq[entry.getValue()].add(entry.getKey());
        }

        int index = 0;
        int[] res = new int[k];
        for(int i = freq.length - 1; 0 < i && index < k; i--){
            for(int n : freq[i]){
                res[index++] = n;
                if(index >= k){
                    return res;
                }
            }
        }
        return res;
    }
}
