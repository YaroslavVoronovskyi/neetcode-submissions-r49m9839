class Solution {
    public int scoreOfString(String s) {
        int result = 0;
        for (int index = 0; index < s.length() - 1; index++) {
            result += Math.abs(s.charAt(index) - s.charAt(index + 1));
        }
        return result;
    }
}