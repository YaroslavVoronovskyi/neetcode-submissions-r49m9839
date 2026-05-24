class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[] steps = {matrix[0].length, matrix.length - 1};
        int r = 0;
        int c = -1;
        int d = 0;
        while (steps[d % 2] > 0) {
            for (int index = 0; index < steps[d % 2]; index++) {
                r += directions[d][0];
                c += directions[d][1];
                result.add(matrix[r][c]);
            }
            steps[d % 2]--;
            d = (d + 1) % 4;
        }
        return result;
    }
}
