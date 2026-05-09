class Solution {
    public String longestPalindrome(String expression) {
        String result = "";
        int resLen = 0;
        for (int i = 0; i < expression.length(); i++) {
            for (int j = i; j < expression.length(); j++) {
                int left = i;
                int right = j;
                while (left < right && expression.charAt(left) == expression.charAt(right)) {
                    left++;
                    right--;
                }
                if (left >= right && resLen < (j - i + 1)) {
                    result = expression.substring(i, j + 1);
                    resLen = j - i + 1;
                }
            }
        }
        return result;
    }
}
