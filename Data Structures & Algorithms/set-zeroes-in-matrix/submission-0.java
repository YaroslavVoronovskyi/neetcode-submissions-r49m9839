class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] mark = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            System.arraycopy(matrix[r], 0, mark[r], 0, cols);
        }
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (matrix[r][c] == 0) {
                    for (int col = 0; col < cols; col++) {
                        mark[r][col] = 0;
                    }
                    for (int row = 0; row < rows; row++) {
                        mark[row][c] = 0;
                    }
                }
            }
        }
        for (int r = 0; r < rows; r++) {
            System.arraycopy(mark[r], 0, matrix[r], 0, cols);
        }
    }
}
