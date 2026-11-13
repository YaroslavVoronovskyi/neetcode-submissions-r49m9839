class Solution {

    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int[][] cache;

    public int longestIncreasingPath(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int path = 0;
        cache = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cache[i][j] = -1;
            }
        }
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                path = Math.max(path, depthFirstSearch(matrix, row, col, Integer.MIN_VALUE));
            }
        }
        return path;
    }

    private int depthFirstSearch(int[][] matrix, int row, int col, int previous) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        if ( row < 0 || row >= rows || col < 0 || col >= cols || matrix[row][col] <= previous) {
            return 0;
        }
        if (cache[row][col] != -1) {
            return cache[row][col];
        }
        int result = 1;
        for (int[] direction : directions) {
            result = Math.max(result, 1 + depthFirstSearch(matrix, row + direction[0], col + direction[1], matrix[row][col]));
        }
        return cache[row][col] = result;
    } 
}
