class Solution {

    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int[][] dp;

    public int longestIncreasingPath(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int lip = 0;
        dp = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                dp[row][col] = -1;
            }
        }
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                lip = Math.max(lip, depthFirstSearch(matrix, row, col, Integer.MIN_VALUE));
            }
        }
        return lip;
    }

    private int depthFirstSearch(int[][] matrix, int row, int col, int prevVal) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (row < 0 || row >= rows || col < 0 || col >= cols || matrix[row][col] <= prevVal) {
            return 0;
        }
        if (dp[row][col] != -1) {
            return dp[row][col];
        }
        int result = 1;
        for (int[] direction : directions) {
            result = Math.max(result, 1 + depthFirstSearch(matrix, row + direction[0], col + direction[1], matrix[row][col]));
        }
        return dp[row][col] = result;
    }
}
