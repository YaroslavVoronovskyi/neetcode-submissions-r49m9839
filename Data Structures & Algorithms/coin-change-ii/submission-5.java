class Solution {
    public int change(int amount, int[] coins) {
        int size = coins.length;
        int[] array = new int[amount + 1];
        array[0] = 1;
        for (int index = size - 1; index >= 0; index-- ) {
            for (int a = 1; a <= amount; a++) {
                array[a] = array[a] + (coins[index] <= a ? array[a - coins[index]] : 0);
            }
        }
        return array[amount];
    }
}
