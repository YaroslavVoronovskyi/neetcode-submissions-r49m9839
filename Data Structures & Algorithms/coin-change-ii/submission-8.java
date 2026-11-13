class Solution {
    public int change(int amount, int[] coins) {
        int size = coins.length;
        Arrays.sort(coins);
        int[][] cache = new int[size + 1][amount + 1];
        
        for (int index = 0; index <= size; index++) {
            cache[index][0] = 1;
        }

        for (int i = size - 1; i >= 0; i--) {
            for (int a = 0; a <= amount; a++) {
                if (a >= coins[i]) {
                    cache[i][a] = cache[i + 1][a];
                    cache[i][a] += cache[i][a - coins[i]]; 
                }
            }
        }
        return cache[0][amount];
    }
}
