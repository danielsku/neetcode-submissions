class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int max = 0;
        for(int n : nums) max = Math.max(max, n);
        return bS(nums,maxOperations, 1, max);
    }

    private int bS(int[] nums, int maxOperations, int l, int r){

        if(r == l) return r;

        int mid = (l + r)/2;
        int numOp = calc(nums, mid);
        if(numOp > maxOperations) return bS(nums, maxOperations, mid + 1, r);
        return bS(nums, maxOperations, l, mid);
    }

    private int calc(int[] nums, int rate){
        int op = 0;
        for(int n : nums) op += ((n + rate - 1)/rate) - 1;
        return op;
    }
}
