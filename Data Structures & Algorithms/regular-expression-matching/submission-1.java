class Solution {

    private Boolean[][] dp;

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        dp = new Boolean[m + 1][n + 1];
        return depthFirstSearch(0, 0, s, p, m, n);
    }

    private boolean depthFirstSearch(int i, int j, String s, String p, int m, int n) {
        if (j == n) {
            return i == m;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        boolean match = i < m && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        if (j + 1 < n && p.charAt(j + 1) == '*') {
            dp[i][j] = depthFirstSearch(i, j + 2, s, p, m, n) || (match && depthFirstSearch(i + 1, j, s, p, m, n));
        } else {
            dp[i][j] = match && depthFirstSearch(i + 1, j + 1, s, p, m, n);
        }
        return dp[i][j];
    }
}
