class Solution {
    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        Queue<int[]> pacificQueue = new LinkedList<>();
        Queue<int[]> atlanticQueue = new LinkedList<>();

        for (int col = 0; col < cols; col++) {
            pacificQueue.add(new int[] {0, col});
            atlanticQueue.add(new int[] {rows - 1, col});
        }

        for (int row = 0; row < rows; row++) {
            pacificQueue.add(new int[] {row, 0});
            atlanticQueue.add(new int[] {row, cols - 1});
        }

        breadthFirstSearch(pacificQueue, pacific, heights);
        breadthFirstSearch(atlanticQueue, atlantic, heights);

        List<List<Integer>> result = new ArrayList<>();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (pacific[row][col] && atlantic[row][col]) {
                    result.add(Arrays.asList(row, col));
                }
            }
        }
        return result;
    }

    private void breadthFirstSearch(Queue<int[]> queue, boolean[][] ocean, int[][] heights) {
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            ocean[row][col] = true;
            for (int[] direction : directions) {
                int nr = row + direction[0];
                int nc = col + direction[1];
                if (nr >= 0 && nr < heights.length && nc >= 0 && nc < heights[0].length &&
                    !ocean[nr][nc] && heights[nr][nc] >= heights[row][col]) {
                        queue.add(new int[]{nr, nc});
                    }
            }
        }
    }
}
