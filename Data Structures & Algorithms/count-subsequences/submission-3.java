class Solution {
    
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (n > m) {
            return 0;
        }
        int[] dp = new int[n + 1];
        int[] nextDp = new int[n + 1];
        dp[n] = 1;
        nextDp[n] = 1;

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                nextDp[j] = dp[j];
                if (s.charAt(i) == t.charAt(j)) {
                    nextDp[j] += dp[j + 1];
                }
            }
            dp = nextDp.clone();
        }
        return dp[0];
    }
}
