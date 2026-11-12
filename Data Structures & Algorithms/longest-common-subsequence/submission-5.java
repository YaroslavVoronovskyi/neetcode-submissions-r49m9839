class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] cache = new int[text1.length() + 1][text2.length() + 1];
        for (int row = text1.length() - 1; row >= 0; row--) {
            for (int col = text2.length() - 1; col >= 0; col--) {
                if (text1.charAt(row) == text2.charAt(col)) {
                    cache[row][col] = 1 + cache[row + 1][col + 1];
                } else {
                    cache[row][col] = Math.max(cache[row][col + 1], cache[row + 1][col]);
                }
            }
        }
        return cache[0][0];
    }
}
