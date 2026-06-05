class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> sol = new HashSet<>();
        for(int i = 0; i < k; i++){
            if(sol.contains(nums[i])) return true;
            sol.add(nums[i]);
        }

        for(int i = k; i < nums.length; i++){
            if(sol.contains(nums[i])) return true;
            sol.remove(nums[i - k]);
            sol.add(nums[i]);
        }
        
        return false;
    }
}