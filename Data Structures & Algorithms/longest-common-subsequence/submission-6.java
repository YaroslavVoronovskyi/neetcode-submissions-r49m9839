class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.length() < text2.length()) {
            String temp = text1;
            text1 = text2;
            text2 = temp;
        }

        int[] previous = new int[text2.length() + 1];
        int[] current = new int[text2.length() + 1];
        
        for (int row = text1.length() - 1; row >= 0; row--) {
            for (int col = text2.length() - 1; col >= 0; col--) {
                if (text1.charAt(row) == text2.charAt(col)) {
                    current[col] = 1 + previous[col + 1];
                } else {
                    current[col] = Math.max(current[col + 1], previous[col]);
                }
            }
            int[] temp = previous;
            previous = current;
            current = temp;
        }
        return previous[0];
    }
}
