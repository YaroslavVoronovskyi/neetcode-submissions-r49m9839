class Solution {

    public int longestCommonSubsequence(String text1, String text2) {
        int[][] array = new int[text1.length() + 1][text2.length() + 1];
        for (int i = text1.length() - 1; i >= 0; i--) {
            for (int j = text2.length() - 1; j >= 0; j--) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    array[i][j] = 1 + array[i + 1][j + 1];
                } else {
                    array[i][j] = Math.max(array[i][j + 1], array[i + 1][j]);
                }
            }
        }
        return array[0][0];
    }
}
