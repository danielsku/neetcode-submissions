// Optimized

class Solution {
    List<List<Integer>> ans;
    List<Integer> quad;
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        ans = new ArrayList<>();
        quad = new ArrayList<>();
        kSum(nums, 4, 0, target);
        return ans;
    }

    public void kSum(int[] nums, int k, int start, long target){
        if(k == 2){
            int l = start, r = nums.length - 1;
            while(l < r){
                int sum = nums[l] + nums[r];
                if(sum == target){
                    
                    ans.add(new ArrayList<>(quad));
                    ans.get(ans.size() - 1).add(nums[l]);
                    ans.get(ans.size() - 1).add(nums[r]);
                    l++;
                    r--;
                    
                    while(l < r && nums[l] == nums[l - 1]) l++;
                    while(l < r && nums[r] == nums[r + 1]) r--;
                }else if(sum < target){
                    l++;
                }else{
                    r--;
                }

            }
            return;
        }

        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i - 1]) continue;
            quad.add(nums[i]);
            kSum(nums, k - 1, i + 1, target - nums[i]);
            quad.remove(quad.size() - 1);
        }
    }
}