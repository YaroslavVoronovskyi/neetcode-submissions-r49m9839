class Solution {

   
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];
        for (int col = 0; col < cols; col++) {
            depthFirstSearch(0, col, pacific, heights);
            depthFirstSearch(rows - 1, col, atlantic, heights);
        }
        for (int row = 0; row < rows; row++) {
            depthFirstSearch(row, 0, pacific, heights);
            depthFirstSearch(row, cols - 1, atlantic, heights);
        }
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

    private void depthFirstSearch(int row, int col, boolean[][] ocean, int[][] heights) {
        ocean[row][col] = true;
        for (int[] direction : directions) {
            int nr = row + direction[0];
            int nc = col + direction[1];
            if (nr >= 0 && nr < heights.length && nc >= 0 && nc < heights[0].length &&
               !ocean[nr][nc] && heights[nr][nc] >= heights[row][col]) {
                depthFirstSearch(nr, nc, ocean, heights);
            }
        }
    }
}
