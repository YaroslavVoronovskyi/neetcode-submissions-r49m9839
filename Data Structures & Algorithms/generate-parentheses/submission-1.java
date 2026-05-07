class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder stack = new StringBuilder();
        backtrack(0, 0, n, result, stack);
        return result;
    }

    private void backtrack(int open, int closed, int n, List<String> result, StringBuilder stack) {
        if (open == closed && open == n) {
            result.add(stack.toString());
            return;
        }
        if (open < n) {
            stack.append('(');
            backtrack(open + 1, closed, n, result, stack);
            stack.deleteCharAt(stack.length() - 1);
        }
        if (closed < open) {
            stack.append(')');
            backtrack(open, closed + 1, n, result, stack);
            stack.deleteCharAt(stack.length() - 1);
        }
    }
}
