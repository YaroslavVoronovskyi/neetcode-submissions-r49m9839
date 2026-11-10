class Solution {
    public String longestPalindrome(String expression) {
        int resultIndex = 0;
        int resultLength = 0;
        int size = expression.length();

        boolean[][] cache = new boolean[size][size];

        for (int outer = size - 1; outer >= 0; outer--) {
            for (int inner = outer; inner < size; inner++) {
                if (expression.charAt(outer) == expression.charAt(inner) && 
                        (inner - outer <= 2 || cache[outer + 1][inner - 1])) {
                    cache[outer][inner] = true;
                    if (resultLength < (inner - outer + 1)) {
                        resultIndex = outer;
                        resultLength = inner - outer + 1;
                    }
                }
            }
        }
        return expression.substring(resultIndex, resultIndex + resultLength);
    }
}
