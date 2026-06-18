class Solution {
    public int maxCoins(int[] nums) {
        int size = nums.length;
        int[] newNums = new int[size + 2];
        newNums[0] = newNums[size + 1] = 1;
        for (int i = 0; i < size; i++) {
            newNums[i + 1] = nums[i];
        }
        int[][] dp = new int[size + 2][size + 2];
        for (int i = 0; i <= size; i++) {
            for (int j = 0; j <= size; j++) {
                dp[i][j] = -1;
            }
        }
        return depthFirstSearch(newNums, 1, newNums.length - 2, dp);
    }

    public int depthFirstSearch(int[] nums, int left, int right, int[][] dp) {
        if (nums.length == 2) {
            return 0;
        }
        if (left > right) {
            return 0;
        }
        if (dp[left][right] != -1) {
            return dp[left][right];
        }
        dp[left][right] = 0;
        for (int i = left; i <= right; i++) {
            int coins = nums[left - 1] * nums[i] * nums[right + 1];
            coins += depthFirstSearch(nums, left, i - 1, dp) + depthFirstSearch(nums, i + 1, right, dp);
            dp[left][right] = Math.max(dp[left][right], coins);
        }
        return dp[left][right];
    }
}
