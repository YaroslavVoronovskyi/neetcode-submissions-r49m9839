class Solution {
    public int countSubstrings(String expression) {
        int result = 0;
        for (int index = 0; index < expression.length(); index++) {
            result += countPalindromes(expression, index, index);
            result += countPalindromes(expression, index, index + 1);
        }
        return result;
    }

    private int countPalindromes(String expression, int left, int right) {
        int result = 0;
        while (left >= 0 && right < expression.length() && expression.charAt(left) == expression.charAt(right)) {
            result++;
            left--;
            right++;
        }
        return result;
    }
}
