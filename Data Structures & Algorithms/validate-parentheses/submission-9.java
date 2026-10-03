class Solution {
    public boolean isValid(String expression) {
        if (expression.length() == 0) {
            return true;
        }
        while (expression.contains("()") || expression.contains("{}") || expression.contains("[]")) {
            expression = expression.replace("()", "");
            expression = expression.replace("{}", "");
            expression = expression.replace("[]", "");
        }
        return expression.isEmpty();
    }
}
