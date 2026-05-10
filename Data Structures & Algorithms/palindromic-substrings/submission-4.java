class Solution {
    public int countSubstrings(String expression) {
        int result = 0;
        int size = expression.length();
        for (int i = 0; i < size; i++) {
            result += countPali(expression, i, i);
            result += countPali(expression, i, i + 1);
        }
        return result;
    }

    private int countPali(String expression, int left, int right) {
        int result = 0;
        while (left >= 0 && right < expression.length() && expression.charAt(left) == expression.charAt(right)) {
            result++;
            left--;
            right++;
        }
        return result;
    }
}
