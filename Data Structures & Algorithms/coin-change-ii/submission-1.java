class Solution {
    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        int[][] memo = new int[coins.length + 1][amount + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return depthFirstSearch(coins, 0, amount, memo);
    }

    private int depthFirstSearch(int[] coins, int index, int amount, int[][] memo) {
        if (amount == 0) {
            return 1;
        }
        if (index >= coins.length) {
            return 0;
        }
        if (memo[index][amount] != -1) {
            return memo[index][amount];
        }
        int result = 0;
        if (amount >= coins[index]) {
            result = depthFirstSearch(coins, index + 1, amount, memo);
            result += depthFirstSearch(coins, index, amount - coins[index], memo);
        }
        memo[index][amount] = result;
        return result;
    }
}
