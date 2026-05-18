class Solution {

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        if (m < n)  {
            String temp = word1;
            word1 = word2;
            word2 = temp;
            m = word1.length();
            n = word2.length();
        }

        int[] array = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            array[i] = n - i;
        }

        for (int i = m - 1; i >= 0; i--) {
            int next = array[n];
            array[n] = m - i;
            for (int j = n - 1; j >= 0; j--) {
                int temp = array[j];
                if (word1.charAt(i) == word2.charAt(j)) {
                    array[j] = next;
                } else {
                    array[j] = 1 + Math.min(array[j],
                                  Math.min(array[j + 1], next));
                }
                next = temp;
            }
        }
        return array[0];
    }
}
