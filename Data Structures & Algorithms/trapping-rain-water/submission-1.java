class Solution {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1;
        int total = 0;

        int leftMax = height[l], rightMax = height[r];
        while(l < r){
            if(leftMax < rightMax){
                l++;
                leftMax = Math.max(leftMax, height[l]);
                total += leftMax - height[l];
            }else{
                r--;
                rightMax = Math.max(rightMax, height[r]);
                total += rightMax - height[r];
            }
        }
        
        return total;
    }
}
