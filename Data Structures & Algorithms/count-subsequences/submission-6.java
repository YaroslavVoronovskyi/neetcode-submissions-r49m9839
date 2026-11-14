class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[] cache = new int[n + 1];
        int[] nextCache = new int[n + 1];

        cache[n] = 1;
        nextCache[n] = 1;

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                nextCache[j] = cache[j];
                if (s.charAt(i) == t.charAt(j)) {
                    nextCache[j] += cache[j + 1];
                }
            }
            cache = nextCache.clone();
        }
        return cache[0];
    }
}
