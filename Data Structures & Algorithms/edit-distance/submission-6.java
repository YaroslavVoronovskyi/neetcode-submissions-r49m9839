class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        if (m < n) {
            int tempSize = m;
            m = n;
            n = tempSize;
            String tempWord = word1;
            word1 = word2;
            word2 = tempWord;
        }
        int[] cache = new int[n + 1];
        int[] nextCache = new int[n + 1];

        for (int index = 0; index <= n; index++) {
            cache[index] = n - index;
        }

        for (int i = m - 1; i >= 0; i--) {
            nextCache[n] = m - i;
            for (int j = word2.length() - 1; j >= 0; j--) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    nextCache[j] = cache[j + 1];
                } else {
                    nextCache[j] = 1 + Math.min(cache[j], Math.min(nextCache[j + 1], cache[j + 1]));
                }
            }
            cache = nextCache.clone();
        }
        return cache[0];
    }
}
