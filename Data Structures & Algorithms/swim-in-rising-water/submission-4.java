class Solution {
    public int swimInWater(int[][] grid) {
        int size = grid.length;
        boolean[][] visit = new boolean[size][size];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        minHeap.offer(new int[]{grid[0][0], 0, 0});
        visit[0][0] = true;
        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int t = current[0];
            int row = current[1];
            int col = current[2];
            if (row == size - 1 && col == size - 1) {
                return t;
            }
            for (int[] direction : directions) {
                int neiRow = row + direction[0];
                int neiCol = col + direction[1];
                if (neiRow >= 0 && neiCol >= 0 && neiRow < size && neiCol < size && !visit[neiRow][neiCol]) {
                    visit[neiRow][neiCol] = true;
                    minHeap.offer(new int[]{Math.max(t, grid[neiRow][neiCol]), neiRow, neiCol});
                }
            }
        }
        return size * size;
    }
}
