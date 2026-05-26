// HashMap solution in O(n) sapce
class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int num : nums){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        for(Map.Entry<Integer, Integer> entry : freq.entrySet()){
            if(entry.getValue() > Math.floor(nums.length/2)){
                return entry.getKey();
            }
        } 
        return 0;
    }
}