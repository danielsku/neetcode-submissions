class Solution {
    public int maxProfit(int[] prices) {
        int total = 0;
        int maxProfit = 0;
        int lowPrice = prices[0];

        for(int i = 0; i < prices.length; i++){
            lowPrice = Math.min(lowPrice, prices[i]);
            if(prices[i] - lowPrice > 0){
                total += prices[i] - lowPrice;
                lowPrice = prices[i];
            }
        }
       
        return total;
    }
}