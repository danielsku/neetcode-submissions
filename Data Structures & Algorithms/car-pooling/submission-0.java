class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Map<Integer, Integer> tripMap = new TreeMap<>();
        for(int[] trip : trips){
            tripMap.put(trip[1], tripMap.getOrDefault(trip[1], 0) + trip[0]);
            tripMap.put(trip[2], tripMap.getOrDefault(trip[2], 0) - trip[0]);
        }
        int currPass = 0;
        for(Map.Entry<Integer, Integer> entry : tripMap.entrySet()){
            currPass += entry.getValue();
            if(currPass > capacity) return false;
        }
        return true;       
    }
}