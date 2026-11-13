class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        if (m + n != s3.length()) {
            return false;
        }
        if (n < m) {
            String tempExpression = s1;
            s1 = s2;
            s2 = tempExpression;
            int tempSize = m;
            m = n;
            n = tempSize;
        }

        boolean[] cache = new boolean[n + 1];
        cache[n] = true;

        for (int i = m; i >= 0; i--) {
            boolean[] nextCache = new boolean[n + 1];
            if (i == m) {
                nextCache[n] = true;
            }
            for (int j = n; j >= 0; j--) {
                if (i < m && s1.charAt(i) == s3.charAt(i + j) && cache[j]) {
                    nextCache[j] = true;
                }
                if (j < n && s2.charAt(j) == s3.charAt(i + j) && nextCache[j + 1]) {
                    nextCache[j] = true;
                }
            }
            cache = nextCache;
        }
        return cache[0];
    }
}
