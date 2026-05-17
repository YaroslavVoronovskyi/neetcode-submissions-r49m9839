class Solution {
    public int change(int amount, int[] coins) {
        int size = coins.length;
        Arrays.sort(coins);
        int[][] array = new int[size + 1][amount + 1];
        for (int index = 0; index < size; index++) {
            array[index][0] = 1;
        }
        for (int index = size - 1; index >= 0; index-- ) {
            for (int a = 0; a <= amount; a++) {
                if (a >= coins[index]) {
                    array[index][a] = array[index + 1][a];
                    array[index][a] += array[index][a - coins[index]];
                }
            }
        }
        return array[0][amount];
    }
}
