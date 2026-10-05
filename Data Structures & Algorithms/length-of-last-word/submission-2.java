class Solution {
    public int lengthOfLastWord(String expression) {
        expression = expression.trim();
        return expression.length() - expression.lastIndexOf(" ") - 1;
    }
}