class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] cache = new int[m + 1][n + 1];

        for (int index = 0; index <= m; index++) {
            cache[index][n] = 1;
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                cache[i][j] = cache[i + 1][j];
                if (s.charAt(i) == t.charAt(j)) {
                    cache[i][j] += cache[i + 1][j + 1];
                }
            }
        }
        return cache[0][0];
    }
}
