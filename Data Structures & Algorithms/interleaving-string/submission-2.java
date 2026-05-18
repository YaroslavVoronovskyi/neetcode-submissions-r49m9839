class Solution {

    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        if (m + n != s3.length()) {
            return false;
        }
        boolean[][] array = new boolean[m + 1][n + 1];
        array[m][n] = true;
        for (int i = m; i >= 0; i--) {
            for (int j = n; j >= 0; j--) {
                if (i < m && s1.charAt(i) == s3.charAt(i + j) && array[i + 1][j]) {
                    array[i][j] = true;
                }
                if (j < n && s2.charAt(j) == s3.charAt(i + j) && array[i][j + 1]) {
                    array[i][j] = true;
                }
            }
        }
        return array[0][0];
    }
}
