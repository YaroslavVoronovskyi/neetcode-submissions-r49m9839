class Solution {

    public String decodeString(String expression) {
        Stack<String> stack = new Stack<>();
        for (int index = 0; index < expression.length(); index++) {
            if (expression.charAt(index) != ']') {
                stack.push(String.valueOf(expression.charAt(index)));
            } else {
                StringBuilder subExpression = new StringBuilder();
                while (!stack.peek().equals("[")) {
                    subExpression.insert(0, stack.pop());
                }
                stack.pop();
                StringBuilder k = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) {
                    k.insert(0, stack.pop());
                }
                int count = Integer.parseInt(k.toString());
                String repeatedExpression = subExpression.toString().repeat(count);
                stack.push(repeatedExpression);
            }
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }
        return result.toString();
    }
}