class Solution {
    public int maxProfit(int[] prices) {
        int lowPrice = prices[0];
        int maxProfit = 0;

        for(int i = 0; i < prices.length; i++){
            lowPrice = Math.min(lowPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - lowPrice);
        }
        return maxProfit;
    }
}
