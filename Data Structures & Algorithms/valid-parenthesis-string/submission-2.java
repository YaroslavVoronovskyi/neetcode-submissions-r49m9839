class Solution {
    public boolean checkValidString(String expression) {
        int size = expression.length();
        boolean[][] memo = new boolean[size + 1][size + 1];
        memo[size][0] = true;

        for (int index = size - 1; index >= 0; index--) {
            for (int open = 0; open < size; open++) {
                boolean result = false;
                if (expression.charAt(index) == '*') {
                    result |= memo[index + 1][open + 1];
                    if (open > 0) {
                        result |= memo[index + 1][open - 1];
                    }
                    result |= memo[index + 1][open];
                } else {
                    if (expression.charAt(index) == '(') {
                        result |= memo[index + 1][open + 1];
                    } else if (open > 0) {
                        result |= memo[index + 1][open - 1];
                    }
                }
                memo[index][open] = result;
            }
        }
        return memo[0][0];
    }
}
