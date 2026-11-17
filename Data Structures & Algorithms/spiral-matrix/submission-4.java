class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[] steps = {matrix[0].length, matrix.length - 1};
        int row = 0;
        int col = -1;
        int down = 0;

        while (steps[down % 2] > 0) {
            for (int index = 0; index < steps[down % 2]; index++) {
                row += directions[down][0];
                col += directions[down][1];
                result.add(matrix[row][col]);
            }
            steps[down % 2]--;
            down = (down + 1) % 4;
        }
        return result;
    }
}
