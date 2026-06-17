class Solution {

    public int longestIncreasingPath(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int[][] indegree = new int[rows][cols];
        
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                for (int[] direction : directions) {
                    int nr = row + direction[0];
                    int nc = col + direction[1];
                    if (nr >= 0 && nr < rows & nc >= 0 && nc < cols && matrix[nr][nc] < matrix[row][col]) {
                        indegree[row][col]++;
                    }
                }
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (indegree[row][col] == 0) {
                    queue.offer(new int[]{row, col});
                }
            }
        }
        int lis = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                int[] node = queue.poll();
                int r = node[0];
                int c = node[1];
                for (int[] direction : directions) {
                    int nr = r + direction[0];
                    int nc = c + direction[1];
                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && matrix[nr][nc] > matrix[r][c]) {
                        if (--indegree[nr][nc] == 0) {
                            queue.offer(new int[]{nr, nc});
                        }
                    }
                }
            }
            lis++; 
        }
        return lis;
    }
}
