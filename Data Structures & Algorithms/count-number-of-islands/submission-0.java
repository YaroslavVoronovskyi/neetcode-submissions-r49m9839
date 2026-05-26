class Solution {

    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int islands = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == '1') {
                    depthFirstSearch(grid, row, col);
                    islands++;
                }
            }
        }
        return islands;
    }

    private void depthFirstSearch(char[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == '0') {
            return;
        }
        grid[row][col] = '0';
        for (int[] direction : directions) {
            depthFirstSearch(grid, row + direction[0], col + direction[1]);
        }
    }
}
