class Solution {

    
    private int inf = 2147483647;
    

    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int rows = grid.length;
        int cols = grid[0].length;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 0) {
                    queue.add(new int[]{row, col});
                } 
            }
        }
        if (queue.size() == 0) {
            return;
        }
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            for (int[] direction : directions) {
                int nr = row + direction[0];
                int nc = col + direction[1];
                if (nr >= rows || nc >= cols || nr < 0 || nc < 0 || grid[nr][nc] != Integer.MAX_VALUE) {
                    continue;
                }
                queue.add(new int[]{nr, nc});
                grid[nr][nc] = grid[row][col] + 1;
            }
        }
    }
}
