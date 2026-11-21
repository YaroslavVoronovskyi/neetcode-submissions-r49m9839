class Solution {
    public boolean isAnagram(String expression, String target) {
        if (expression.length() != target.length()) {
            return false;
        }
        int[] counts = new int[26];
        for (int index = 0; index < expression.length(); index++) {
            counts[expression.charAt(index) - 'a']++;
            counts[target.charAt(index) - 'a']--;
        }
        for (int value : counts) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }
}
