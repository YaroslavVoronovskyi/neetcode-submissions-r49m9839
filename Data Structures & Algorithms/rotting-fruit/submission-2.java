class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int fresh = 0;
        int time = 0;
        for (int[] ints : grid) {
            for (int c = 0; c < cols; c++) {
                if (ints[c] == 1) {
                    fresh++;
                }
            }
        }
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (fresh > 0) {
            boolean flag = false;
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    if (grid[r][c] == 2) {
                        for (int[] direction : directions) {
                            int row = r + direction[0];
                            int col = c + direction[1];
                            if (row >= 0 && col >= 0 && row < rows && col < cols && grid[row][col] == 1) {
                                grid[row][col] = 3;
                                fresh--;
                                flag = true;
                            }
                        }
                    }
                }
            }
            if (!flag) {
                return -1;
            }
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    if (grid[r][c] == 3) {
                        grid[r][c] = 2;
                    }
                }
            }
            time++;
        }
        return time;
    }
}
