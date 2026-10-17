class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int r[] = new int[n];
        for(int i = 0; i < n; i++)
            r[i] = -1;
        return robMem(r, nums, n - 1);
    }

    private int robMem(int[] r, int[] nums, int n){
        if(n < 0) return 0;
        if(r[n] >= 0)
            return r[n];
        int q = -1;
        if(n == 0){
            q = nums[0];
        } else{
            q = Math.max(
                    robMem(r, nums, n - 1), 
                    nums[n] + robMem(r, nums, n - 2)
                );
        }
        
        r[n] = q;
        return q;
    }
}
