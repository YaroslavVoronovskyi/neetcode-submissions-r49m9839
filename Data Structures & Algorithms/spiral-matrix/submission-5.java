class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;
        depthFirstSearch(rows, cols, 0, -1, 0, 1, matrix, result);
        return result;
    }

    private void depthFirstSearch(int rows, int cols, int row, int col, int dr, int dc, int[][] matrix, List<Integer> result) {
        if (rows == 0 || cols == 0) {
            return;
        }
        for (int index = 0; index < cols; index++) {
            row += dr;
            col += dc;
            result.add(matrix[row][col]);
        }
        depthFirstSearch(cols, rows - 1, row, col, dc, -dr, matrix, result);
    } 
}
