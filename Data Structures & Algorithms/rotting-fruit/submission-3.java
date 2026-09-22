class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new ArrayDeque<>();
        int fresh = 0;
        int time = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    fresh++;
                }
                if (grid[row][col] == 2) {
                    queue.offer(new int[]{row, col});
                }
            }
        }

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (fresh > 0 && !queue.isEmpty()) {
            int length = queue.size();
            for (int index = 0; index < length; index++) {
                int[] current = queue.poll();
                int r = current[0];
                int c = current[1];

                for (int[] direction : directions) {
                    int row = r + direction[0];
                    int col = c + direction[1];
                    if(row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == 1) {
                        grid[row][col] = 2;
                        queue.offer(new int[]{row, col});
                        fresh--;
                    }
                }
            }
            time++;
        }
        return fresh == 0 ? time : -1;
    }
}
