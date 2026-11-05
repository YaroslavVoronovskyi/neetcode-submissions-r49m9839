class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int inf = Integer.MAX_VALUE;
        int[] prices = new int[n];
        Arrays.fill(prices, inf);
        prices[src] = 0;

        for (int index = 0; index <= k; index++) {
            int[] tempPrices = Arrays.copyOf(prices, n);

            for (int[] flight : flights) {
                int s = flight[0];
                int d = flight[1];
                int p = flight[2];

                if (prices[s] == inf) {
                    continue;
                }

                if (prices[s] + p < tempPrices[d]) {
                    tempPrices[d] = prices[s] + p;
                }
            }
            prices = tempPrices;
        }
        return prices[dst] == inf ? -1 : prices[dst];
    }
}
