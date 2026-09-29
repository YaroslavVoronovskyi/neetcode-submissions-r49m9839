class Solution {
    public boolean isAnagram(String expression, String target) {
        if(expression.length() != target.length()) {
            return false;
        }
        char[] expressionArray = expression.toCharArray();
        char[] targetArray = target.toCharArray(); 
        Arrays.sort(expressionArray);
        Arrays.sort(targetArray);
        return Arrays.equals(expressionArray, targetArray);
    }
}
