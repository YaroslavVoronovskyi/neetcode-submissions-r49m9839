class Solution {
    public int maxProfit(int[] prices) {
        int size = prices.length;
        int nextBuy = 0;
        int nextSell = 0;
        int curBuy = 0;
        int curSell = 0;
        int[][] dp = new int[size + 1][2];
        for (int index = size - 1; index >= 0; index--) {
            curBuy = Math.max(nextBuy, -prices[index] + nextSell);
            curSell = Math.max(nextSell, prices[index] + nextBuy);
            nextBuy = curBuy;
            nextSell = curSell;
        }
        return curBuy;
    }
}