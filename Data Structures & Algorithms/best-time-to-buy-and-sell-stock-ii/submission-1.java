class Solution {
    public int maxProfit(int[] prices) {
        int size = prices.length;
        int[][] dp = new int[size][2];
        for (int index = 0; index < size; index++) {
            dp[index][0] = -1;
            dp[index][1] = -1;
        }
        return recursion(prices, 0, 0, dp);
    }

    private int recursion(int[] prices, int index, int bought, int[][] dp) {
        if (index == prices.length) {
            return 0;
        }
        if (dp[index][bought] != -1) {
            return dp[index][bought];
        }
        int result = recursion(prices, index + 1, bought, dp);
        if (bought == 1) {
            result = Math.max(result, prices[index] + recursion(prices, index + 1, 0, dp));
        } else {
            result = Math.max(result, -prices[index] + recursion(prices, index + 1, 1, dp));
        }
        dp[index][bought] = result;
        return result;
    }
}