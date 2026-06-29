class Solution {
    public boolean validPalindrome(String expression) {
        int left = 0;
        int right = expression.length() - 1;
        while (left < right) {
            if (expression.charAt(left) != expression.charAt(right)) {
                return isPalindrome(expression.substring(0, left) + expression.substring(left + 1)) ||
                       isPalindrome(expression.substring(0, right) + expression.substring(right + 1));
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean isPalindrome(String expression) {
        int left = 0;
        int right = expression.length() - 1;
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