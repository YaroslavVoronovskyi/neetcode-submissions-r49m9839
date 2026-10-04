class Solution {
    public boolean isPalindrome(String expression) {
        StringBuilder newExpression = new StringBuilder();
        for (char character : expression.toCharArray()) {
            if (Character.isLetterOrDigit(character)) {
                newExpression.append(Character.toLowerCase(character));
            }
        }
        return newExpression.toString().equals(newExpression.reverse().toString());
    }
}
