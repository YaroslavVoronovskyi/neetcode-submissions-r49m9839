class Solution {
    public int change(int amount, int[] coins) {
        int size = coins.length;
        int[] array = new int[amount + 1];
        array[0] = 1;
        for (int index = size - 1; index >= 0; index-- ) {
            int[] next = new int[amount + 1];
            next[0] = 1;
            for (int a = 1; a <= amount; a++) {
                next[a] = array[a];
                if (a - coins[index] >= 0) {
                    next[a] += next[a - coins[index]];
                }
            }
            array = next;
        }
        return array[amount];
    }
}
