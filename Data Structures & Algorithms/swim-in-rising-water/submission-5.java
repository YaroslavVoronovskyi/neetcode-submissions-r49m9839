class Solution {
    public int swimInWater(int[][] grid) {
        int size = grid.length;
        boolean[][] visited = new boolean[size][size];
        Queue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        minHeap.offer(new int[]{grid[0][0], 0, 0});
        visited[0][0] = true;

        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int t = current[0];
            int r = current[1];
            int c = current[2];
            if (r == size - 1 && c == size - 1) {
                return t;
            }
            for (int[] direction : directions) {
                int neighborR = r + direction[0];
                int neighborC = c + direction[1];
                if (neighborR >= 0 && neighborC >= 0 && neighborR < size && neighborC < size && !visited[neighborR][neighborC]) {
                    visited[neighborR][neighborC] = true;
                    minHeap.offer(new int[]{Math.max(t, grid[neighborR][neighborC]), neighborR, neighborC});
                }
            }
        }
        return size * size;
    }
}
