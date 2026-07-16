class Solution {
    public int maxProfit(int[] prices) {
        int size = prices.length;
        int profit = 0;
        for (int index = 1; index < size; index++) {
            if (prices[index] > prices[index - 1]) {
                profit += (prices[index] - prices[index - 1]);
            }
        }
        return profit;
    }
}