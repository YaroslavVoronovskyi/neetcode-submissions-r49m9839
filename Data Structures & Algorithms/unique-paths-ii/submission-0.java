class Solution {
    
    private int[][] dp;
    
    public int uniquePathsWithObstacles(int[][] grid) {
        int rowSize = grid.length;
        int colSize = grid[0].length;
        dp = new int[rowSize][colSize];
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                dp[i][j] = -1;
            }
        }
        return depthFirstSearch(0, 0, grid, rowSize, colSize);
    }

    private int depthFirstSearch(int row, int col, int[][] grid, int rowSize, int colSize) {
        if (row == rowSize || col == colSize || grid[row][col] == 1) {
            return 0;
        }
        if (row == rowSize - 1 && col == colSize - 1) {
            return 1;
        }
        if (dp[row][col] != -1) {
            return dp[row][col];
        }
        dp[row][col] = depthFirstSearch(row + 1, col, grid, rowSize, colSize) + 
            depthFirstSearch(row, col + 1, grid, rowSize, colSize);
        return dp[row][col];
    }
}