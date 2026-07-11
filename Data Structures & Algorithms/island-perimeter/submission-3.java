class Solution {

    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int result = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 1) {
                    result += 4;
                    if (row > 0 && grid[row - 1][col] == 1) {
                        result -= 2;
                    }
                    if (col > 0 && grid[row][col - 1] == 1) {
                        result -= 2;
                    }
                }
            }
        }
        return result;
    }
}