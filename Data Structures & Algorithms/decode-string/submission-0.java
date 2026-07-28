class Solution {

    int index = 0; 

    public String decodeString(String expression) {
        return helper(expression);
    }

    private String helper(String expression) {
        StringBuilder result = new StringBuilder();
        int k = 0;

        while (index < expression.length()) {
            char character = expression.charAt(index);
            if (Character.isDigit(character)) {
                k = k * 10 + (character - '0');
            } else if (character == '[') {
                index++;
                String subResult = helper(expression);
                while (k-- > 0) {
                    result.append(subResult);
                }
                k = 0;
            } else if (character == ']') {
                return result.toString();
            } else {
                result.append(character);
            }
            index++;
        }
        return result.toString();
    }
}