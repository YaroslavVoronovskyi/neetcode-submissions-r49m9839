class Solution {
    public int change(int amount, int[] coins) {
        int size = coins.length;
        int[] array = new int[amount + 1];
        array[0] = 1;
        for (int coin : coins ) {
            for (int a = coin; a <= amount; a++) {
                array[a] = array[a] + array[a - coin];
            }
        }
        return array[amount];
    }
}
