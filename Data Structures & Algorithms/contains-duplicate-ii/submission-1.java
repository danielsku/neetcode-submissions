class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums.length < k) k = nums.length;

        HashSet<Integer> window = new HashSet<>();
        for(int i = 0; i < k; i++){
            if(window.contains(nums[i])) return true;
            window.add(nums[i]);
        }

        for(int i = k; i < nums.length; i++){
            if(window.contains(nums[i])) return true;
            window.remove(nums[i - k]);
            window.add(nums[i]);
        }

        return false;
    }
}