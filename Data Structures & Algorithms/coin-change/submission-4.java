class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] cache = new int [amount + 1];
        Arrays.fill(cache, amount + 1);
        cache[0] = 0;
        for (int outer = 1; outer <= amount; outer++) {
            for (int inner = 0; inner < coins.length; inner++) {
                if (coins[inner] <= outer) {
                    cache[outer] = Math.min(cache[outer], cache[outer - coins[inner]] + 1);
                }
            }
        }
        return cache[amount] > amount ? -1 : cache[amount];
    }
}
