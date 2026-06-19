class Solution {

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[] dp = new boolean[n + 1];
        dp[n] = true;

        for (int i = m; i >= 0; i--) {
            boolean dp1 = dp[n];
            dp[n] = (i == m);
            for (int j = n - 1; j >= 0; j--) {
                boolean match = i < m && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
                boolean result = false;
                if ((j + 1) < n && p.charAt(j + 1) == '*') {
                    result = dp[j + 2];
                    if (match) {
                        result |= dp[j];
                    }
                } else if (match) {
                    result = dp1;
                }
                dp1 = dp[j];
                dp[j] = result;
            }
        }
        return dp[0];
    }
}
