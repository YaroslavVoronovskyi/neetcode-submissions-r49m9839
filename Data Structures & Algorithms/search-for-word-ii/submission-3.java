class Solution {

    public List<String> findWords(char[][] board, String[] words) {
        int rows = board.length;
        int cols = board[0].length;
        List<String> result = new ArrayList<>();
        for (String word : words) {
            boolean flag = false;
            for (int row = 0; row < rows && !flag; row++) {
                for (int col = 0; col < cols; col++) {
                    if (board[row][col] != word.charAt(0)) {
                        continue;
                    }
                    if (backtrack(board, row, col, word, 0)) {
                        result.add(word);
                        flag = true;
                        break;
                    }
                }
            }
        }
        return result;
    }

    private boolean backtrack(char[][] board, int row, int col, String word, int index) {
        if (index == word.length()) {
            return true;
        }
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != word.charAt(index)) {
            return false;
        }
        board[row][col] = '*';
        boolean ret = backtrack(board, row + 1, col, word, index + 1) ||
                backtrack(board, row - 1, col, word, index + 1) ||
                backtrack(board, row, col + 1, word, index + 1) ||
                backtrack(board, row, col - 1, word, index + 1);
        board[row][col] = word.charAt(index);
        return ret;
    }
}
