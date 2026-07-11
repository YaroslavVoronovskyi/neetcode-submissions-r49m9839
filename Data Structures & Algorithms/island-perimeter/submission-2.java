class Solution {

    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int result = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 1) {
                    result += (row + 1 >= rows || grid[row + 1][col] == 0) ? 1 : 0;
                    result += (col + 1 >= cols || grid[row][col + 1] == 0) ? 1 : 0;
                    result += (row - 1 < 0 || grid[row - 1][col] == 0) ? 1 : 0;
                    result += (col - 1 < 0 || grid[row][col - 1] == 0) ? 1 : 0;
                }
            }
        }
        return result;
    }
}