class Solution {
    public boolean checkValidString(String expression) {
        int size = expression.length();
        Boolean[][] memo = new Boolean[size + 1][size + 1];
        return depthFirstSearch(0, 0, expression, memo);
    }

    private boolean depthFirstSearch(int index, int open, String expression, Boolean[][] memo) {
        if (open < 0) {
            return false;
        }
        if (index == expression.length()) {
            return open == 0;
        }
        if (memo[index][open] != null) {
            return memo[index][open];
        }
        boolean result;
        if (expression.charAt(index) == '(') {
            result = depthFirstSearch(index + 1, open + 1, expression, memo);
        } else if (expression.charAt(index) == ')') {
            result = depthFirstSearch(index + 1, open - 1, expression, memo);
        } else {
            result = depthFirstSearch(index + 1, open, expression, memo) ||
                     depthFirstSearch(index + 1, open + 1, expression, memo) ||
                     depthFirstSearch(index + 1, open - 1, expression, memo);
        }
        memo[index][open] = result;
        return result;
    }
}
