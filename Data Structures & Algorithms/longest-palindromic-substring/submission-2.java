class Solution {
    public String longestPalindrome(String expression) {
        int resIdx = 0;
        int resLen = 0;
        int size = expression.length();
        boolean[][] array = new boolean[size][size];
        for (int i = size - 1; i >= 0; i--) {
            for (int j = i; j < size; j++) {
                if (expression.charAt(i) == expression.charAt(j) &&
                       (j - i <= 2 || array[i + 1][j -1])) {
                    array[i][j] = true;
                    if (resLen < (j - i + 1)) {
                        resIdx = i;
                        resLen = j - i + 1;
                    }
                }
            }
        }
        return expression.substring(resIdx, resIdx + resLen);
    }
}
