class Solution {
    public int change(int amount, int[] coins) {
        int[] cache = new int[amount + 1];
        cache[0] = 1;

        for (int i = coins.length - 1; i >= 0; i--) {
            for (int a = 0; a <= amount; a++) {
                cache[a] = cache[a] + (coins[i] <= a ? cache[a - coins[i]] : 0); 
            }
        }
        return cache[amount];
    }
}
