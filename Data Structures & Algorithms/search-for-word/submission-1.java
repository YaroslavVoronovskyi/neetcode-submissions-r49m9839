class Solution {

    private int ROWS;
    private int COLS;
    private boolean[][] isVisited;

    public boolean exist(char[][] board, String word) {
        ROWS = board.length;
        COLS = board[0].length;
        isVisited = new boolean[ROWS][COLS];

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (depthFiratSearch(board, word, r, c, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean depthFiratSearch(char[][] board, String word, int r, int c, int i) {
        if (i == word.length()) {
            return true;
        }
        if (r < 0 || c <0 || r >= ROWS || c >= COLS || 
        board[r][c] != word.charAt(i) || isVisited[r][c]) {
            return false;
        }
        isVisited[r][c] = true;
        boolean result = depthFiratSearch(board, word, r + 1, c, i + 1) ||
                         depthFiratSearch(board, word, r - 1, c, i + 1) ||
                         depthFiratSearch(board, word, r, c + 1, i + 1) ||
                         depthFiratSearch(board, word, r, c - 1, i + 1);
        isVisited[r][c] = false;
        return result;
    }
}
