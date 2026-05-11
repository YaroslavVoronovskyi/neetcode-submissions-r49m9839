class Solution {

    int[][] memo;

    public int lengthOfLIS(int[] numbers) {
        int size = numbers.length;
        memo = new int[size][size + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return depthFirstSearch(0, -1, numbers);
    }

    private int depthFirstSearch(int i, int j, int[] numbers) {
        if (i == numbers.length) {
            return 0;
        }
        if (memo[i][j + 1] != -1) {
            return memo[i][j + 1];
        }
        int result = depthFirstSearch(i + 1, j, numbers);
        if (j == -1 || numbers[j] < numbers[i]) {
            result = Math.max(result, 1 + depthFirstSearch(i + 1, i, numbers));
        }
        memo[i][j + 1] = result;
        return result;
    }
}
