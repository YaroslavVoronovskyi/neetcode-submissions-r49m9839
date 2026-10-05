class Solution {
    public int lengthOfLastWord(String expression) {
        int size = expression.length();
        int index = size - 1;
        int length = 0;
        while (expression.charAt(index) == ' ') {
            index--;
        }
        while (index >= 0 && expression.charAt(index) != ' ') {
            index--;
            length++;
        }
        return length;
    }
}