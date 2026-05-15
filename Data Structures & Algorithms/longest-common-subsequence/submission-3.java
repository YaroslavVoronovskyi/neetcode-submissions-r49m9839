class Solution {

    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.length() < text2.length()) {
            String temp = text1;
            text1 = text2;
            text2 = temp;
        }
        int[] previous = new int[text2.length() + 1];
        int[] current = new int[text2.length() + 1];
        for (int i = text1.length() - 1; i >= 0; i--) {
            for (int j = text2.length() - 1; j >= 0; j--) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    current[j] = 1 + previous[j + 1];
                } else {
                    current[j] = Math.max(current[j + 1], previous[j]);
                }
            }
            int[] temp = previous;
            previous = current;
            current = temp;
        }
        return previous[0];
    }
}
