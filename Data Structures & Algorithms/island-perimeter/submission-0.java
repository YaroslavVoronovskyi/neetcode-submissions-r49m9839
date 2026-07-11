class Solution {

    private int[][] grid;
    private boolean[][] visited;
    private int rows;
    private int cols;

    public int islandPerimeter(int[][] grid) {
        this.grid = grid;
        this.rows = grid.length;
        this.cols = grid[0].length;
        this.visited = new boolean[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 1) {
                    return depthFirstSearch(row, col);
                }
            }
        }
        return 0;
    }

    private int depthFirstSearch(int row, int col) {
        if (row < 0 || col < 0 || row >= rows || col >= cols || grid[row][col] == 0) {
            return 1;
        }
        if (visited[row][col]) {
            return 0;
        }
        visited[row][col] = true;
        return depthFirstSearch(row, col + 1) + depthFirstSearch(row + 1, col) + 
               depthFirstSearch(row, col - 1) + depthFirstSearch(row - 1, col);
    }
}