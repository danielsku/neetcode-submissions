class Solution {
    public int shipWithinDays(int[] weights, int days) {
        
        int total = 0;
        int min = 0;
        for(int weight : weights){
            total += weight;
            if(weight > min){
                min = weight;
            }
        }

        int l = min;
        int r = total;

        while(l <= r){
            int m = (l + r)/2;

            int count = 0;
            int order1 = 0;
            for(int i = 0; i<weights.length; i++){
                count += weights[i];
                if( (i < weights.length - 1 && count + weights[i+1] > m)
                || (i == weights.length - 1 && count != 0)){
                    order1++;
                    count = 0;
                }
            }

            int order2 = 0;
            for(int i = weights.length - 1; i >= 0; i--){
                count += weights[i];
                if((i > 0 && count + weights[i-1] > m)
                || (i == 0 && count != 0)){
                    order2++;
                    count = 0;
                }
            }

            System.out.println(m + " " + order1 + " " + order2);
            int rate = (int) Math.min(order1, order2);

            if(rate <= days){
                r = m - 1;
            }else if(rate > days) {
                l = m + 1;
            }
        }
        return l;
    }
}