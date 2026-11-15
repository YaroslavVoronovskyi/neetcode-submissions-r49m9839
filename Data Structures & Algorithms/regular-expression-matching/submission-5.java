class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] cache = new boolean[m + 1][n + 1];
        cache[m][n] = true;

        for (int i = m; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                boolean match = i < m && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
                if ((j + 1) < n && p.charAt(j + 1) == '*') {
                    cache[i][j] = cache[i][j + 2];
                    if (match) {
                        cache[i][j] = cache[i + 1][j] || cache[i][j];
                    }
                } else if (match) {
                    cache[i][j] = cache[i + 1][j + 1];
                }
            }
        }
        return cache[0][0];
    }
}
