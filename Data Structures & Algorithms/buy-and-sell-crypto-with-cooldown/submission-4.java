class Solution {

    public int maxProfit(int[] prices) {
        int size = prices.length;
        int result = 0;
        int sell = 0;
        int buy = 0;
        for (int index = size - 1; index >= 0; index--) {
            int tempBuy = Math.max(sell - prices[index], result);
            int tempSell = Math.max(buy + prices[index], sell);
            buy = result;
            result = tempBuy;
            sell = tempSell;
        }
        return result;
    }
}
