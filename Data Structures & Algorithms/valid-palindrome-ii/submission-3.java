class Solution {
    public boolean validPalindrome(String expression) {
        int left = 0;
        int right = expression.length() - 1;
        while (left < right) {
            if (expression.charAt(left) != expression.charAt(right)) {
                return isPalindrome(expression, left + 1, right) ||
                       isPalindrome(expression, left, right - 1);
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean isPalindrome(String expression, int left, int right) {
        while (left < right) {
            if (expression.charAt(left) != expression.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}