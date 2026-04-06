class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        int size = prices.length;
        for (int i = 0; i < size; i++) {
            int buy = prices[i];
            for (int j = i + 1; j < size; j++) {
                int sell = prices[j];
                result = Math.max(result, sell - buy);
            }
        }
        return result;
    }
}
