class Solution {
    public int uniquePaths(int m, int n) {
        int[] row = new int[n];
        Arrays.fill(row, 1);

        for (int outer = 0; outer < m - 1; outer++) {
            int[] newRow = new int[n];
            Arrays.fill(newRow, 1);
            for (int inner = n - 2; inner >= 0; inner--) {
                newRow[inner] = newRow[inner + 1] + row[inner];
            }
            row = newRow;
        }
        return row[0];
    }
}
