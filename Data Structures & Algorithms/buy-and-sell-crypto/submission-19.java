class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        int minBuy = prices[0];
        
        for (int sell : prices) {
            result = Math.max(result, sell - minBuy);
            minBuy = Math.min(minBuy, sell);
        }
        return result;
    }
}
