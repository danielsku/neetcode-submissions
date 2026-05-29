class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        // Find the maximum
        int max = piles[0];
        for(int i = 1; i < piles.length; i++){
            if(piles[i] > max) max = piles[i];
        }


        int l = 1;
        int r = max;
        int min = -1;
        int current = -1;

        while(l<=r){
            int m = l + (r - l)/2; // Rewrite if overflow

            int rate = 0;
            for(int pile : piles){
                rate += (pile + m - 1) / m;
            }
            System.out.println(m + " : " + rate);

            if(rate <= h){
                r = m - 1;
                current = m;
            }else if(rate > h){
                l = m + 1;
            }
        }

        return current;


    }
}
