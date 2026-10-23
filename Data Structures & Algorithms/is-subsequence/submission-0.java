class Solution {
    public boolean isSubsequence(String expression, String target) {
        int i = 0;
        int j = 0;
        while (i < expression.length() && j < target.length()) {
            if (expression.charAt(i) == target.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == expression.length();
    }
}