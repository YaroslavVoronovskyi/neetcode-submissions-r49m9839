class Solution {

    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.length() < text2.length()) {
            String temp = text1;
            text1 = text2;
            text2 = temp;
        }
        int[] array = new int[text2.length() + 1];
        for (int i = text1.length() - 1; i >= 0; i--) {
            int previous = 0;
            for (int j = text2.length() - 1; j >= 0; j--) {
                int temp = array[j];
                if (text1.charAt(i) == text2.charAt(j)) {
                    array[j] = 1 + previous;
                } else {
                    array[j] = Math.max(array[j], array[j + 1]);
                }
                previous = temp;
            }
        }
        return array[0];
    }
}
