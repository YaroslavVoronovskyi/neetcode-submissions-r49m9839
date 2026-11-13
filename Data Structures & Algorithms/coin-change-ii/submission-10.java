class Solution {
    public int change(int amount, int[] coins) {
        int[] cache = new int[amount + 1];
        cache[0] = 1;

        for (int coin : coins) {
            for (int index = coin; index <= amount; index++) {
                cache[index] += cache[index - coin];
            }
        }
        return cache[amount];
    }
}
