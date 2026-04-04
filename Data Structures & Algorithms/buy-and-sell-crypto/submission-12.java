class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        int left = 0;
        int right = 1;
        while (right < prices.length) {
            if (prices[left] < prices[right]) {
                int profit = prices[right] - prices[left];
                result = Math.max(result, profit);
            } else {
                left = right;
            }
            right++;
        }
        return result;
    }
}
