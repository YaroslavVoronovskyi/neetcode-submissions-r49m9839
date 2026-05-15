class Solution {

    private Map<String, Integer> map = new HashMap<>();

    public int maxProfit(int[] prices) {
        return depthFirstSearch(0, true, prices);
    }

    private int depthFirstSearch(int index, boolean isBuying, int[] prices) {
        if (index >= prices.length) {
            return 0;
        }
        String key = index + "-" + isBuying;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        int cooldown = depthFirstSearch(index + 1, isBuying, prices);
        if (isBuying) {
            int buy = depthFirstSearch(index + 1, false, prices) - prices[index];
            map.put(key, Math.max(buy, cooldown)); 
        } else {
            int sell = depthFirstSearch(index + 2, true, prices) + prices[index];
            map.put(key, Math.max(sell, cooldown));
        }
        return map.get(key);
    }
}
