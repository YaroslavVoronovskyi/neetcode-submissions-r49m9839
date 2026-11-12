class Solution {
    public int maxProfit(int[] prices) {
        int size = prices.length;
        int cache1buy = 0;
        int cache1sell = 0;
        int cache2buy = 0;

        for (int index = size - 1; index >= 0; index--) {
            int cacheBuy = Math.max(cache1sell - prices[index], cache1buy);
            int cacheSell = Math.max(cache2buy + prices[index], cache1sell);
            cache2buy = cache1buy;
            cache1buy = cacheBuy;
            cache1sell = cacheSell;
        }
        return cache1buy;
    }
}
