class Solution {

    private boolean[] col;
    private boolean[] posDiag;
    private boolean[] negDiag;
    private char[][] board;
    private List<List<String>> result;

    public List<List<String>> solveNQueens(int n) {
        col = new boolean[n];
        posDiag = new boolean[2*n];
        negDiag = new boolean[2*n];
        result = new ArrayList<>();
        board = new char[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        backtrack(0, n);
        return result;
    }

    private void backtrack(int r, int n) {
        if (r == board.length) {
            List<String> copy = new ArrayList<>();
            for (char[] row : board) {
                copy.add(new String(row));
            }
            result.add(copy);
            return;
        }
        for (int c = 0; c < board.length; c++) {
            if (col[c] || posDiag[r + c] || negDiag[r - c + n]) {
                continue;
            }
            col[c] = true;
            posDiag[r + c] = true;
            negDiag[r -c + n] = true;
            board[r][c] = 'Q';

            backtrack(r + 1, n);

            col[c] = false;
            posDiag[r + c] = false;
            negDiag[r - c + n] = false;
            board[r][c] = '.';
        }
    }
}
