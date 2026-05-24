class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> result = new ArrayList<>();
        depthFirstSearch(m, n, 0, -1, 0, 1, matrix, result);
        return result;
    }

    private void depthFirstSearch(int row, int col, int r, int c, int dr, int dc,
                                  int[][] matrix, List<Integer> result) {
        if (row == 0 || col == 0) {
            return;
        }
        for (int index = 0; index < col; index++) {
            r += dr;
            c += dc;
            result.add(matrix[r][c]);
        }
        depthFirstSearch(col, row - 1, r, c, dc, -dr, matrix, result);
    }
}
