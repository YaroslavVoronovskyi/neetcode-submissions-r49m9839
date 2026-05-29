class Solution {

    private int rows;
    private int cols;

    public void solve(char[][] board) {
        rows = board.length;
        cols = board[0].length;
        
        for (int row = 0; row < rows; row++) {
            if (board[row][0] == 'O') {
                capture(board, row, 0);
            }
            if (board[row][cols - 1] == 'O') {
                capture(board, row, cols - 1);
            }
        }

        for (int col = 0; col < cols; col++) {
            if (board[0][col] == 'O') {
                capture(board, 0, col);
            }
            if (board[rows - 1][col] == 'O') {
                capture(board, rows - 1, col);
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] == 'O') {
                    board[row][col] = 'X';
                } else if (board[row][col] == 'T') {
                    board[row][col] = 'O';
                }
            }
        }
    }

    private void capture(char[][] board, int row, int col) {
        if (row < 0 || col < 0 || row >= rows || col >= cols || board[row][col] != 'O') {
            return;
        }
        board[row][col] = 'T';
        capture(board, row + 1, col);
        capture(board, row - 1, col);
        capture(board, row, col + 1);
        capture(board, row, col - 1);
    }
}
