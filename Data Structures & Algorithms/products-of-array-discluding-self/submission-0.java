// Resolve this (Also look at Prefix sum and Suffix sum)

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int prefix[] = new int[n];
        int suffix[] = new int[n];
        int answer[] = new int[n];

        prefix[0] = 1;
        suffix[n-1] = 1;

        // Prefix
        for(int i = 1; i<n; i++){
            prefix[i] = prefix[i-1]*nums[i-1];
            suffix[n - 1 - i] = suffix[n - i]*nums[n - i];
        }
        
        // Suffix
        for(int i = nums.length - 2; i>=0; i--){
            suffix[i] = suffix[i+1]*nums[i+1];
        }

        // The answer
        for(int i = 0; i<nums.length; i++){
            answer[i] = prefix[i] * suffix[i];
        }

        return answer;
    }
}  
