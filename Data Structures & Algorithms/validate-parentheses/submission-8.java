class Solution {
    public boolean isValid(String expression) {
        if (expression.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        for (char character : expression.toCharArray()) {
            if (map.containsKey(character)) {
                if (!stack.isEmpty() && stack.peek() == map.get(character)) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(character);
            }
        }
        return stack.isEmpty();
    }
}
