class Solution {

    private int result;

    public int totalNQueens(int n) {
        result = 0;
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        backtrack(0, board);
        return result;
    }

    private void backtrack(int row, char[][] board) {
        if (row == board.length) {
            result++;
            return;
        }
        for (int col = 0; col < board.length; col++) {
            if (isSafe(row, col, board)) {
                board[row][col] = 'Q';
                backtrack(row + 1, board);
                board[row][col] = '.';
            }
        }
    }

    private boolean isSafe(int row, int col, char[][] board) {
        for (int index = row - 1; index >= 0; index--) {
            if (board[index][col] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}