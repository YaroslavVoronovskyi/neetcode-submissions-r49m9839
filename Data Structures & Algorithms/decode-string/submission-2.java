class Solution {

    public String decodeString(String expression) {
        Stack<String>  stringStack = new Stack<>();
        Stack<Integer>  countStack = new Stack<>();
        StringBuilder current = new StringBuilder();
        int k = 0;
        for (char character : expression.toCharArray()) {
            if (Character.isDigit(character)) {
                k = k * 10 + (character - '0');
            } else if (character == '[') {
                stringStack.push(current.toString());
                countStack.push(k);
                current = new StringBuilder();
                k = 0;
            } else if (character ==']') {
                String temp = current.toString();
                current = new StringBuilder(stringStack.pop());
                int count = countStack.pop();
                for (int index = 0; index < count; index++) {
                    current.append(temp);
                }
            } else {
                current.append(character);
            }
        }
        return current.toString();
    }
}