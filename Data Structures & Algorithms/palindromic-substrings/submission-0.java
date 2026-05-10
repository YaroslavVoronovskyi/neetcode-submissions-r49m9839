class Solution {
    public int countSubstrings(String expression) {
        int result = 0;
        for (int i = 0; i < expression.length(); i++) {
            for (int j = i; j < expression.length(); j++) {
                int left = i;
                int right = j;
                while (left < right && expression.charAt(left) == expression.charAt(right)) {
                    left++;
                    right--;
                }
                result += (left >= right) ? 1 : 0;
            }
        }
        return result;
    }
}
