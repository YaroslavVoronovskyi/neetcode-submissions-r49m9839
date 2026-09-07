class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;

        int top = 0;
        int bot = ROWS - 1;
        while (top <= bot) {
            int row = top + ((bot - top) / 2);
            if (target > matrix[row][COLS - 1]) {
                top = row +1;
            } else if (target < matrix[row][0]) {
                bot = row - 1;
            } else {
                break;
            }
        }

        if (!(top <= bot)) {
            return false;
        }

        int row = top + ((bot - top) / 2);
        int left = 0;
        int right = COLS - 1;
        while (left <= right) {
            int middle = left + ((right - left) / 2);
            if (target > matrix[row][middle]) {
                left = middle + 1;
            } else if (target < matrix[row][middle]) {
                right = middle - 1;
            } else {
                return true;
            }
         }
        return false;
    }
}
