class Solution {

    public int coinChange(int[] coins, int amount) {
        int[] array = new int[amount + 1];
        Arrays.fill(array, amount + 1);
        array[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    array[i] = Math.min(array[i], array[i - coins[j]] + 1);
                }
            }
        }
        return array[amount] > amount ? -1 : array[amount];
    }
}
