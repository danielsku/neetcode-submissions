class Solution {
    public int mySqrt(int x) {
        int l = 0;
        int r = x;
        int last = -1;

        while(l <= r){
            int m = l + (r - l)/2;
            if((long)m*m <= x){
                l = m + 1;
                last = m;
            }else{
                r = m - 1;
            }
        }
        return last;
    }
}