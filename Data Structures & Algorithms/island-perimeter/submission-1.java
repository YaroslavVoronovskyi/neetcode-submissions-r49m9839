class Solution {

    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 1) {
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{row, col});
                    visited[row][col] = true;
                    int perimeter = 0;

                    while(!queue.isEmpty()) {
                        int[] cell = queue.poll();
                        int x = cell[0];
                        int y = cell[1];
                        for (int[] direction : directions) {
                            int nx = x + direction[0];
                            int ny = y + direction[1];
                            if (nx < 0 || ny < 0 || nx >= rows || ny >= cols || grid[nx][ny] == 0) {
                                perimeter++;
                            } else if (!visited[nx][ny]) {
                                visited[nx][ny] = true;
                                queue.offer(new int[]{nx, ny});
                            }
                        }
                    }
                    return perimeter;
                }
            }
        }
        return 0;
    }
}