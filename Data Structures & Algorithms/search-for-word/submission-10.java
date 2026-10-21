class Solution {
    private int rows;
    private int cols;

    public boolean exist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (backtrack(board, word, row, col, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word, int row ,int col, int index) {
        if (index == word.length()) {
            return true;
        }

        if (row < 0 || col < 0 || row >= rows || col >= cols || board[row][col] != word.charAt(index) || board[row][col] == '#') {
            return false;
        }

        board[row][col] = '#';
        boolean result = backtrack(board, word, row + 1, col, index + 1) ||
                      backtrack(board, word, row - 1, col, index + 1) ||
                      backtrack(board, word, row, col + 1, index + 1) ||
                      backtrack(board, word, row, col - 1, index + 1);
        board[row][col] = word.charAt(index);
        return result;
    }
}
