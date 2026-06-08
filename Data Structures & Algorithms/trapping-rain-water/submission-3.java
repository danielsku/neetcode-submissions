class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int l = 0, r = height.length - 1;
        int maxLeft = height[l];
        int maxRight = height[r];
        int water = 0;
        while(l < r){
            if(height[l] > height[r]){
                r--;
                maxRight = Math.max(maxRight, height[r]);
                water += maxRight - height[r];
            }else if(height[l] <= height[r]) {
                l++;
                maxLeft = Math.max(maxLeft, height[l]);
                water += maxLeft - height[l];
            }
        }
        return water;
    }
}
