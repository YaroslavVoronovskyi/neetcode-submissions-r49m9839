class Solution {
    public int maxProfit(int[] prices) {
        int size = prices.length;
        int[][] dp = new int[size + 1][2];
        for (int index = size - 1; index >= 0; index--) {
            dp[index][0] = Math.max(dp[index + 1][0], -prices[index] + dp[index + 1][1]);
            dp[index][1] = Math.max(dp[index + 1][1], prices[index] + dp[index + 1][0]);
        }
        return dp[0][0];
    }
}