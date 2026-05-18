class Solution {

    public int minDistance(String word1, String word2) {
        int[][] array = new int[word1.length() + 1][word2.length() + 1];
        for (int j = 0; j < word2.length(); j++) {
            array[word1.length()][j] = word2.length() - j;
        }
        for (int i = 0; i <= word1.length(); i++) {
            array[i][word2.length()] = word1.length() - i;
        }
        for (int i = word1.length() - 1; i >= 0; i--) {
            for (int j = word2.length() - 1; j >= 0; j--) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    array[i][j] = array[i + 1][j + 1];
                } else {
                    array[i][j] = 1 + Math.min(array[i + 1][j],
                                      Math.min(array[i][j + 1], array[i + 1][j + 1]));
                }
            }
        }
        return array[0][0];
    }
}
