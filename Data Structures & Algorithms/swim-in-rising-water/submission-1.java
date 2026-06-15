class Solution {
    public int swimInWater(int[][] grid) {
        int size = grid.length;
        boolean[][] visit = new boolean[size][size];
        int minH = grid[0][0];
        int maxH = grid[0][0];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                maxH = Math.max(maxH, grid[row][col]);
                minH = Math.min(minH, grid[row][col]);
            }
        }
        for (int t = minH; t < maxH; t++) {
            if (depthFirstSearch(grid, visit, 0, 0, t)) {
                return t;
            }
            for (int r = 0; r < size; r++) {
                Arrays.fill(visit[r], false);
            }
        }
        return maxH;
    }

    private boolean depthFirstSearch(int[][] grid, boolean[][] visit, int row, int col, int t) {
        int size = grid.length;
        if (row < 0 || col < 0 || row >= size || col >= size || visit[row][col] || grid[row][col] > t) {
            return false;
        }
        if (row == size - 1 && col == size - 1) {
            return true;
        }
        visit[row][col] = true;
        return  depthFirstSearch(grid, visit, row + 1, col, t) ||
                depthFirstSearch(grid, visit, row - 1, col, t) ||
                depthFirstSearch(grid, visit, row, col + 1, t) ||
                depthFirstSearch(grid, visit, row, col - 1, t);
    }
}
