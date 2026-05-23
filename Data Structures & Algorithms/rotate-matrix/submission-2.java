class Solution {
    public void rotate(int[][] matrix) {
        reverse(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[i].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    private void reverse(int[][] matrix) {
        int size = matrix.length;
        for (int index = 0; index < size / 2; index++) {
            int[] temp = matrix[index];
            matrix[index] = matrix[size - 1 - index];
            matrix[size - 1 - index] = temp;
        }
    }
}
