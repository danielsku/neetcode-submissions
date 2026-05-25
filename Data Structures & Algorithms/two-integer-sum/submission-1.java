class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> n = new HashMap<>();
        int k = 0;
        int ans[] = new int[2];
        for(int num : nums){
            n.put(num, k++);
        }
        for(int i = 0; i<nums.length; i++){
            if(n.get(target - nums[i]) != null && n.get(target - nums[i]) != i ){
                int x = n.get(target - nums[i]);
                ans[0] = i;
                ans[1] = x;
                return ans;
            }
        }
        return null;
    }
}
