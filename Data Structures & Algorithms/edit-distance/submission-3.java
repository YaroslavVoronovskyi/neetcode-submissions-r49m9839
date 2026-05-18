class Solution {

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        if (m < n)  {
            int temp = m;
            m = n;
            n = temp;
            String word = word1;
            word1 = word2;
            word2 = word;
        }

        int[] array = new int[n + 1];
        int[] next = new int[n + 1];
        for (int j = 0; j <= n; j++) {
            array[j] = n - j;
        }

        for (int i = m - 1; i >= 0; i--) {
            next[n] = m - i;
            for (int j = n - 1; j >= 0; j--) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    next[j] = array[j + 1];
                } else {
                    next[j] = 1 + Math.min(array[j],
                                  Math.min(next[j + 1], array[j + 1]));
                }
            }
            System.arraycopy(next, 0, array, 0, n + 1);
        }
        return array[0];
    }
}
