class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        depthFirstSearch("", result, n);
        return result;
    }

    private void depthFirstSearch(String expression, List<String> result, int n) {
        if (n * 2 == expression.length()) {
            if (isValid(expression)) {
                result.add(expression);
            }
            return;
        }
        depthFirstSearch(expression + '(', result, n);
        depthFirstSearch(expression + ')', result, n);
    }

    private boolean isValid(String expression) {
        int open = 0;
        for (char character : expression.toCharArray()) {
            open += character == '(' ? 1 : -1;
            if (open < 0) {
                return false;
            }
        }
        return open == 0;
    }
}
