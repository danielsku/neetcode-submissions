// Resolve this without outside help (and learn about Iterators in Java)

class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> startNums = new ArrayList<>();
        int max = 0;

        for(int num : nums){
            map.put(num, num + 1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(map.containsKey(entry.getKey() - 1)){
                startNums.add(entry.getKey());
            }
        }
        
        if(startNums.isEmpty()) return 1;

        for(int num : startNums){
            int a = num;
            int temp = 1;

            while(map.containsKey(a)){
                a = map.get(a);
                temp++;
            }

            if(temp > max){
                max = temp;
            }
        }

    

        return max;
        
    }
}
