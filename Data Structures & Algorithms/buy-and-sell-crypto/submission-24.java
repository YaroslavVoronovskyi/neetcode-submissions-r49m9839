class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                profit = max(profit, prices[j] - prices[i]);
            }
        }
        return profit;
    }

    private int max(int a, int b) {
        if (a >= b) {
            return a;
        } else {
            return b;
        }
    }
}
