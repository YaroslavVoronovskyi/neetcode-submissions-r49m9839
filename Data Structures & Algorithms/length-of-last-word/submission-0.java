class Solution {
    public int lengthOfLastWord(String expression) {
        String[] array = expression.split(" ");
        String last = array[array.length - 1];
        return last.length();
    }
}