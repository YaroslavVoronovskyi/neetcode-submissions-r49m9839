class Solution {

    private int cols = 0;
    private int posDiag = 0;
    private int negDiag = 0;
    private int result = 0;

    public int totalNQueens(int n) {
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
            if ((cols & (1 << col)) > 0 || (posDiag & (1 << (row + col))) > 0 || (negDiag & (1 << (row - col + n))) > 0) {
                continue;
            }
            cols ^= (1 << col);
            posDiag ^= (1 << (row + col));
            negDiag ^= (1 << (row - col + n));
            backtrack(row + 1, n);
            cols ^= (1 << col);
            posDiag ^= (1 << (row + col));
            negDiag ^= (1 << (row - col + n));
        }
    }
}