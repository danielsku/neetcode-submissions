class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        for(int k = 0; k < nums.length - 2; k++){
            if (k > 0 && nums[k] == nums[k - 1]) continue;
            int i = k + 1;
            int j = nums.length - 1;
            while(i < j){
                int temp = nums[i] + nums[j] + nums[k];
                if(temp == 0){
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    i++;
                    j--;
                    while (i < j && nums[i] == nums[i - 1]) i++;
                    while (i < j && nums[j] == nums[j + 1]) j--;
                }else if(temp < 0){
                    i++;
                }else{
                    j--;
                }
            }
        }
        return ans;
    }
}
