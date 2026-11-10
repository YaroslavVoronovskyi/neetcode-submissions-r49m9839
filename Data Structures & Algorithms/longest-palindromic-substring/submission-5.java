class Solution {
    public String longestPalindrome(String expression) {
        String result = "";
        int resultLength = 0;

        for (int outer = 0; outer < expression.length(); outer++) {
            for (int inner = outer; inner < expression.length(); inner++) {
                int left = outer;
                int right = inner;
                while (left < right && expression.charAt(left) == expression.charAt(right)) {
                    left++;
                    right--;
                }
                if (left >= right && resultLength < (inner - outer + 1)) {
                    result = expression.substring(outer, inner + 1);
                    resultLength = inner - outer + 1;
                }
            }
        }
        return result;
    }
}
