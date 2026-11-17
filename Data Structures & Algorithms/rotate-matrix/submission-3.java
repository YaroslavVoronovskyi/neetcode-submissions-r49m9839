class Solution {
    public void rotate(int[][] matrix) {
        int size = matrix.length;
        int[][] rotated = new int[size][size];

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                rotated[col][size - 1 - row] = matrix[row][col];
            }
        }

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                matrix[row][col] = rotated[row][col];
            }
        }
    }
}
