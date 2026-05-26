class Solution {

    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int inf = 2147483647;
    private int rows;
    private int cols;

    public void islandsAndTreasure(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == inf) {
                    grid[row][col] = breadthFirstSearch(grid, row, col);
                } 
            }
        }
    }

    private int breadthFirstSearch(int[][] grid, int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        boolean[][] visit = new boolean[rows][cols];
        visit[r][c] = true;
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int index = 0; index < size; index++) {
                int[] current = queue.poll();
                int row = current[0];
                int col = current[1];
                if (grid[row][col] == 0) {
                    return steps;
                }
                for (int[] direction : directions) {
                    int nr = row + direction[0];
                    int nc = col + direction[1];
                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && !visit[nr][nc] && grid[nr][nc] != -1) {
                        visit[nr][nc] = true;
                        queue.add(new int[]{nr, nc});
                    }
                }
            }
            steps++;
        }
        return inf;
    }
}
