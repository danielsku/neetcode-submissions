class Solution {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length - 1;
        int max = 0;

        while(l < r){
            int temp = (int) Math.min(heights[l], heights[r])*(r-l);
            if(temp > max){
                max = temp;
            }
            if(heights[l] > heights[r]){
                r--;
            }else{
                l++;
            }
        }
        
        return max;
    }
}
