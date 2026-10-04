class Solution {
    public boolean isPalindrome(String expression) {
        int left = 0;
        int right = expression.length() - 1;

        while (left < right) {
            while (left < right && !isAlphaNumber(expression.charAt(left))) {
                left++;
            }
            while (right > left && !isAlphaNumber(expression.charAt(right))) {
                right--;
            }
            if (Character.toLowerCase(expression.charAt(left)) != 
                    Character.toLowerCase(expression.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean isAlphaNumber(char character) {
        return (character >= 'A' && character <= 'Z' ||
                character >= 'a' && character <= 'z' ||
                character >= '0' && character <= '9');
    }
}
