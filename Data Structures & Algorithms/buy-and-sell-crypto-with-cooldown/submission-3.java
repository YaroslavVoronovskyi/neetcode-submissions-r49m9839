class Solution {

    public int maxProfit(int[] prices) {
        int size = prices.length;
        int[][] array = new int[size + 1][2];
        for (int index = size - 1; index >= 0; index--) {
            for (int buying = 1; buying >= 0; buying--) {
                if (buying == 1) {
                    int buy = array[index + 1][0] - prices[index];
                    int cooldown = array[index + 1][1];
                    array[index][1] = Math.max(buy, cooldown);
                } else {
                    int sell = (index + 2 < size) ? array[index + 2][1] + prices[index] : prices[index];
                    int cooldown = array[index + 1][0];
                    array[index][0] = Math.max(sell, cooldown);
                }
            }
        }
        return array[0][1];
    }
}
