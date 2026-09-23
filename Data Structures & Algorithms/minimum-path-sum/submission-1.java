class Solution {
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[] dp = new int[cols + 1];
        for (int col = 0; col <= cols; col++) {
            dp[col] = Integer.MAX_VALUE;
        }
        dp[cols - 1] = 0;
        for (int row = rows - 1; row >= 0; row--) {
            for (int col = cols - 1; col >= 0; col--) {
                dp[col] = grid[row][col] + Math.min(dp[col], dp[col + 1]);
            } 
        }
        return dp[0];
    }
}