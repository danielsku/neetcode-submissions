class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int solution[] = new int[k];
        HashMap<Integer, Integer> ans = new HashMap<>();
        for(int num : nums){
            ans.put(num, ans.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<PriorityKey<Integer, Integer>> sorted = new PriorityQueue<>(Collections.reverseOrder());
        for(Map.Entry<Integer, Integer> entry : ans.entrySet()){
            sorted.add(new PriorityKey<>(entry.getKey(), entry.getValue()));
        }

        for(int i = 0; i<k; i++){
            solution[i] = sorted.poll().getKey();
        }

        return solution;
    }
}

class PriorityKey<K, V extends Integer> implements Comparable<PriorityKey<K,V>> {
    private K key; 
    private V value;

    public PriorityKey(K key, V value){
        this.key = key;
        this.value = value;
    }

    public V getValue(){
        return value;
    }

    public K getKey(){
        return key;
    }
    
    @Override
    public int compareTo(PriorityKey<K, V> other){
        if(other == null){
            throw new NullPointerException("Cannot compare with null");
        }

        return Integer.compare(this.getValue(), other.getValue());
    }
}
