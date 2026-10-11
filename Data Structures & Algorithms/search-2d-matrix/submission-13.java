class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] rows : matrix) {
            for (int index = 0; index < rows.length; index++) {
                if (rows[index] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}
