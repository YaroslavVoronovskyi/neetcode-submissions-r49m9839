class Solution {
    public boolean checkValidString(String expression) {
        int size = expression.length();
        boolean[] memo = new boolean[size + 1];
        memo[0] = true;

        for (int index = size - 1; index >= 0; index--) {
            boolean[] array = new boolean[size + 1];
            for (int open = 0; open < size; open++) {
                if (expression.charAt(index) == '*') {
                    array[open] = memo[open + 1] || (open > 0 && memo[open - 1]) || memo[open];
                } else if (expression.charAt(index) == '(') {
                    array[open] = memo[open + 1];
                } else if (open > 0) {
                    array[open] = memo[open - 1];
                }
            }
            memo = array;
        }
        return memo[0];
    }
}
