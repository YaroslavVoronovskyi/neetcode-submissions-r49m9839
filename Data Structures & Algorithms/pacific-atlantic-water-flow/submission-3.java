class Solution {

    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        boolean[][] pac = new boolean[rows][cols];
        boolean[][] atl = new boolean[rows][cols];

        for (int col = 0; col < cols; col++) {
            depthFirstSearch(0, col, pac, heights);
            depthFirstSearch(rows - 1, col, atl, heights);
        }

        for (int row = 0; row < rows; row++) {
            depthFirstSearch(row, 0, pac, heights);
            depthFirstSearch(row, cols - 1, atl, heights);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (pac[row][col] && atl[row][col]) {
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
