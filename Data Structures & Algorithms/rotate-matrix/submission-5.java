class Solution {
    public void rotate(int[][] matrix) {
        int left = 0;
        int right = matrix.length - 1;

        while (left < right) {
            for (int index = 0; index < right - left; index++) {
                int top = left;
                int bottom = right;
                int topLeft = matrix[top][left + index];
                matrix[top][left + index] = matrix[bottom - index][left];
                matrix[bottom - index][left] = matrix[bottom][right - index];
                matrix[bottom][right - index] = matrix[top + index][right];
                matrix[top + index][right] = topLeft;
            }
            right--;
            left++;
        }
    }
}
