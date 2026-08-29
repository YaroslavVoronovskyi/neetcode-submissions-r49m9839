class Solution {
    public boolean isValid(String expression) {
        while (expression.contains("()") || expression.contains("[]") || expression.contains("{}")) {
            expression = expression.replace("()", "");
            expression = expression.replace("{}", "");
            expression = expression.replace("[]", "");
        }
        return expression.isEmpty();
    }
}
