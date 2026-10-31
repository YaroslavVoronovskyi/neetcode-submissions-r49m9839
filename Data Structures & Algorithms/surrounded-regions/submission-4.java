class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        capture(board);

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

    private void capture(char[][] board) {
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int rows = board.length;
        int cols = board[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if ((row == 0 || row == rows - 1 || col == 0 || col == cols - 1) && 
                    board[row][col] == 'O') {
                        queue.offer(new int[]{row, col});
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];
            if (board[row][col] == 'O') {
                board[row][col] = 'T';
                for (int[] direction : directions) {
                    int nr = row + direction[0];
                    int nc = col + direction[1];
                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols) {
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
        } 
    }
}
