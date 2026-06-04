class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();
        HashSet<List<Integer>> col = new HashSet<>();

        int l1 = 0;
        int l2 = 1;
        int l3 = 2;
        int r = nums.length - 1;

        while(l2 != nums.length - 2){
            while(l3 != nums.length - 1){
                while(l3 < r){
                    long a = (long)nums[l1] + nums[l2] + nums[l3] + nums[r];
                    if(a == target){
                        List<Integer> entry = new ArrayList<>();
                        entry.addAll(Arrays.asList(
                            nums[l1], nums[l2], nums[l3], nums[r]
                        ));
                        col.add(entry);
                        l3++;
                        r--;
                    }else if(a < target){
                        l3++;
                    }else{
                        r--;
                    }
                }
                l2++;
                l3 = l2 + 1;
                r = nums.length - 1;
            }
            l1++;
            l2 = l1 + 1;
            l3 = l2 + 1;
            r = nums.length - 1;
        }

        for(List<Integer> e : col){
            ans.add(e);
        }

        return ans;
    }
}