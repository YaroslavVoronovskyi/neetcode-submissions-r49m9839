class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        int[][] distantion = new int [rows][cols];
        for (int[] row : distantion) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        distantion[0][0] = 0;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        minHeap.offer(new int[] {0, 0, 0});
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int difference = current[0];
            int row = current[1];
            int col = current[2];

            if (row == rows - 1 && col == cols - 1) {
                return difference;
            } 
            if (distantion[row][col] < difference) {
                continue;
            }

            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];
                if (newRow < 0 || newCol < 0 || newRow >= rows || newCol >= cols) {
                    continue;
                }
                int newDifference = Math.max(difference, Math.abs(heights[row][col] - heights[newRow][newCol]));
                if (newDifference < distantion[newRow][newCol]) {
                    distantion[newRow][newCol] = newDifference;
                    minHeap.offer(new int[]{newDifference, newRow, newCol});
                }
            }
        }
        return 0;
    }
}