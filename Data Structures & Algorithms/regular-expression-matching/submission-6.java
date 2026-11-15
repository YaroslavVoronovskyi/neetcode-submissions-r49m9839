class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[] cache = new boolean[n + 1];
        cache[n] = true;

        for (int i = m; i >= 0; i--) {
            boolean[] nextCache = new boolean[n + 1];
            nextCache[n] = i == m;
            for (int j = n - 1; j >= 0; j--) {
                boolean match = i < m && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
                if (j + 1 < n && p.charAt(j + 1) == '*') {
                    nextCache[j] = nextCache[j + 2];
                    if (match) {
                        nextCache[j] |= cache[j];
                    }
                } else if (match) {
                    nextCache[j] = cache[j + 1];
                }
            }
            cache = nextCache;
        }
        return cache[0];
    }
}
