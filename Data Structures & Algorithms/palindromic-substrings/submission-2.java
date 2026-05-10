class Solution {
    public int countSubstrings(String expression) {
        int result = 0;
        int size = expression.length();
        boolean[][] array = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            int left = i;
            int right = i;
            while (left >= 0 && right < size && expression.charAt(left) == expression.charAt(right)) {
                result++;
                left--;
                right++;
            }
            left = i;
            right = i + 1;
            while (left >= 0 && right < size && expression.charAt(left) == expression.charAt(right)) {
                result++;
                left--;
                right++;
            }
        }
        return result;
    }
}
