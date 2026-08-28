class Solution {

    private boolean[] cols;
    private boolean[] posDiag;
    private boolean[] negDiag;
    private int result;

    public int totalNQueens(int n) {
        cols = new boolean[n];
        posDiag = new boolean[2 * n];
        negDiag = new boolean[2 * n];
        result = 0;
        backtrack(0, n);
        return result;
    }

    private void backtrack(int row, int n) {
        if (row == n) {
            result++;
            return;
        }
        for (int col = 0; col < n; col++) {
            if (cols[col] || posDiag[row + col] || negDiag[row - col + n]) {
                continue;
            }
            cols[col] = true;
            posDiag[row + col] = true;
            negDiag[row - col + n] = true;
            backtrack(row + 1, n);
            cols[col] = false;
            posDiag[row + col] = false;
            negDiag[row - col + n] = false;
        }
    }
}