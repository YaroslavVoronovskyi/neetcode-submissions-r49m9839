class Solution {
    public boolean isValidSudoku(char[][] board) {
    int[] rows = new int[9];
    int[] cols = new int[9];
    int[] squares = new int[9];

    for (int row = 0; row < 9; row++) {
        for (int col = 0; col < 9; col++) {
            if (board[row][col] == '.') {
                continue;
            }
            int value = board[row][col] - '1';
            if ((rows[row] & (1 << value)) > 0 || (cols[col] & (1 << value)) > 0 || 
                (squares[(row / 3) * 3 + (col / 3)] & (1 << value)) > 0) {
                return false;
            }

            rows[row] |= (1 << value);
            cols[col] |= (1 << value);
            squares[(row / 3) * 3 + (col / 3)] |= (1 << value);
        }
    }
    return true;
    }
}
