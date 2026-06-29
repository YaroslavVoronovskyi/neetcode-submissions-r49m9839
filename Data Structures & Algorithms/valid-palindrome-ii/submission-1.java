class Solution {
    public boolean validPalindrome(String expression) {
        if (isPalindrome(expression)) {
            return true;
        }
        for (int index = 0; index <expression.length(); index++) {
            String newExpression = expression.substring(0, index) + expression.substring(index + 1);
            if (isPalindrome(newExpression)) {
                return true;
            }
        }
        return false;
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