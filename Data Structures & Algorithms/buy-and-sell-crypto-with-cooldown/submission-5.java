class Solution {
    public int maxProfit(int[] prices) {
        int size = prices.length;
        int[][] cache = new int[size + 1][2];

        for (int index = size - 1; index >= 0; index--) {
            for (int buying = 1; buying >= 0; buying--) {
                if (buying == 1) {
                    int buy = cache[index + 1][0] - prices[index];
                    int cooldown = cache[index + 1][1];
                    cache[index][1] = Math.max(buy, cooldown);
                } else {
                    int sell = (index + 2 < size) ? cache[index + 2][1] + prices[index] : prices[index];
                    int cooldown = cache[index + 1][0];
                    cache[index][0] = Math.max(sell, cooldown);
                }
            }
        }
        return cache[0][1];
    }
}
