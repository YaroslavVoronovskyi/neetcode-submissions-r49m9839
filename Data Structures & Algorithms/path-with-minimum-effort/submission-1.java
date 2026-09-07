class Solution {

    private int ROWS;
    private int COLS;
    private int[][] heights;
    private int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private boolean[][] visited;

    public int minimumEffortPath(int[][] heights) {
        this.heights = heights;
        this.ROWS = heights.length;
        this.COLS = heights[0].length;
        this.visited = new boolean[ROWS][COLS];
        
        int left = 0;
        int right = 1000000;
        int result = right;

        while (left <= right) {
            int middle = (left + right) / 2;
            for (boolean[] row : visited) {
                Arrays.fill(row, false);   
            }
            if (depthFirstSearch(0, 0, middle)) {
                result = middle;
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return result;
    }

    private boolean depthFirstSearch(int row, int col, int limit) {
        if (row == ROWS - 1 && col == COLS - 1) {
            return true;
        }
        visited[row][col] = true;
        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if (newRow < 0 || newCol < 0 || newRow >= ROWS || newCol >= COLS || visited[newRow][newCol]) {
                continue;
            }
            if (Math.abs(heights[newRow][newCol] - heights[row][col]) > limit) {
                continue;
            }
            if (depthFirstSearch(newRow, newCol, limit)) {
                return true;
            }
        }
        return false;
    }
}