class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;
        List<int[]>[] list = new ArrayList[n];
        for (int index = 0; index < n; index++) {
            list[index] = new ArrayList<>();
        }
        for (int[] flight : flights) {
            list[flight[0]].add(new int[]{flight[1], flight[2]});
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, src, 0});

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int cst = curr[0];
            int node = curr[1];
            int stops = curr[2];
            if (stops > k) {
                continue;
            }
            for (int[] item : list[node]) {
                int nei = item[0];
                int w = item[1];
                int nextCost = cst + w;
                if (nextCost < prices[nei]) {
                    prices[nei] = nextCost;
                    queue.offer(new int[]{nextCost, nei, stops + 1});
                }
            }
        }
        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
}
