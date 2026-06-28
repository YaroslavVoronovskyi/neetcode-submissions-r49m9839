class Solution {
    public void reverseString(char[] s) {
        Stack<Character> stack = new Stack<>();
        for (char character : s) {
            stack.push(character);
        }
        int i = 0;
        while (!stack.isEmpty()) {
            s[i++] = stack.pop();
        }
    }
}