class Solution {

    public int uniquePaths(int m, int n) {
        int[][] array = new int[m + 1][n + 1];
        array[m - 1][n - 1] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                array[i][j] += array[i + 1][j] + array[i][j + 1];
            }
        }
        return array[0][0];
    }
}
