// Resolve this

class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        // Find the maximum
        int r = piles[0];
        for(int i = 1; i < piles.length; i++){
            if(piles[i] > r) r = piles[i];
        }


        int l = 1;

        while(l<=r){
            int m = (l+r)/2; // Rewrite if overflow

            int rate = 0;
            for(int pile : piles){
                rate += (pile + m - 1) / m;
            }

            if(rate <= h){
                r = m - 1;
            }else if(rate > h){
                l = m + 1;
            }
        }

        return l;


    }
}
