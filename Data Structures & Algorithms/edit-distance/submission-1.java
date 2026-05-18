class Solution {

    private int[][] array;

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        array = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = -1;
            }
        }
        return depthFirstSearch(0, 0, word1, word2, m, n);
    }

    private int depthFirstSearch(int i, int j, String word1, String word2, int m, int n) {
        if (i == m) {
            return n - j;
        }
        if (j == n) {
            return m - i;
        }
        if (array[i][j] != -1) {
            return array[i][j];
        }
        if (word1.charAt(i) == word2.charAt(j)) {
            array[i][j] = depthFirstSearch(i + 1, j + 1, word1, word2, m, n);
        } else {
            int result = Math.min(depthFirstSearch(i + 1, j, word1, word2, m, n),
                                   depthFirstSearch(i, j  +1, word1, word2, m, n));
            result = Math.min(result, depthFirstSearch(i + 1, j + 1, word1, word2, m, n));
            array[i][j] = result + 1;
        }
        return array[i][j];
    }
}
