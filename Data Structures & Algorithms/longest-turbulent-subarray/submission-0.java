class Solution {
    public int maxTurbulenceSize(int[] array) {
        int size = array.length;
        if (size == 0) {
            return 1;
        }
        int[][] dp = new int[size][2];
        for (int index = 0; index < size; index++) {
            dp[index][0] = 1;
            dp[index][1] = 1;
        }
        int maxLength = 1;
        for (int index = 1; index < size; index++) {
            if (array[index] > array[index - 1]) {
                dp[index][1] = dp[index - 1][0] + 1;
            } else if (array[index] < array[index - 1]) {
                dp[index][0] = dp[index - 1][1] + 1;
            }
            maxLength = Math.max(maxLength, dp[index][0]);
            maxLength = Math.max(maxLength, dp[index][1]);
        }
        return maxLength;
    }
}