class Solution {
    public int maxCoins(int[] nums) {
        int size = nums.length;
        int[] newNums = new int[size + 2];
        newNums[0] = newNums[size + 1] = 1;
        for (int i = 0; i < size; i++) {
            newNums[i + 1] = nums[i];
        }
        int[][] dp = new int[size + 2][size + 2];
        for (int left = size; left >= 1; left--) {
            for (int right = left; right <= size; right++) {
                for (int index = left; index <= right; index++) {
                    int coins = newNums[left - 1] * newNums[index] * newNums[right + 1];
                    coins += dp[left][index - 1]  + dp[index + 1][right];
                    dp[left][right] = Math.max(dp[left][right], coins);
                }
            }
        }
        return dp[1][size];
    }
}
