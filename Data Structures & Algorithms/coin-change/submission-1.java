class Solution {

    Map<Integer, Integer> memo = new HashMap<>();

    public int coinChange(int[] coins, int amount) {
        int minCoins = depthFirstSearch(amount, coins);
        return minCoins == Integer.MAX_VALUE ? -1 : minCoins;
    }

    private int depthFirstSearch(int amount, int[] coins) {
        if (amount == 0) {
            return 0;
        }
        if (memo.containsKey(amount)) {
            return memo.get(amount);
        }
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (amount - coin >= 0) {
                int result = depthFirstSearch(amount - coin, coins);
                if (result != Integer.MAX_VALUE) {
                    res = Math.min(res, 1 + result);
                }
            }
        }
        memo.put(amount, res);
        return res;
    }
}
