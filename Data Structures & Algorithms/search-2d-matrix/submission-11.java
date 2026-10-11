class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] rows : matrix) {
            int left = 0;
            int right = rows.length - 1;
            while (left <= right) {
                int middle = left + (right - left) / 2;
                if (rows[middle] == target) {
                    return true;
                }
                if (rows[middle] < target) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
        }
        return false;
    }
}
