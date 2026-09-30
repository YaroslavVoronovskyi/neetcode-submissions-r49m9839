class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int row = 0; row < 9; row++) {
            Set<Character> seen = new HashSet<>();
            for (int index = 0; index < 9; index++) {
                if (board[row][index] == '.') {
                    continue;
                }
                if (seen.contains(board[row][index])) {
                    return false;
                }
                seen.add(board[row][index]);
            }
        }

        for (int col = 0; col < 9; col++) {
            Set<Character> seen = new HashSet<>();
            for (int index = 0; index < 9; index++) {
                if (board[index][col] == '.') {
                    continue;
                }
                if (seen.contains(board[index][col])) {
                    return false;
                }
                seen.add(board[index][col]);
            }
        }

        for (int square = 0; square < 9; square++) {
            Set<Character> seen = new HashSet<>();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int row = (square / 3) * 3 + i;
                    int col = (square % 3) * 3 + j;
                    if (board[row][col] == '.') {
                        continue;
                    }
                    if (seen.contains(board[row][col])) {
                        return false;
                    }
                    seen.add(board[row][col]);
                }
            }
        }
        return true;
    }
}
