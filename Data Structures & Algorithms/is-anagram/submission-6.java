class Solution {
    public boolean isAnagram(String expression, String target) {
        if (expression.length() != target.length()) {
            return false;
        }
        int[] count = new int[26];
        for (int index = 0; index < expression.length(); index++) {
            count[expression.charAt(index) - 'a']++;
            count[target.charAt(index) - 'a']--;
        }
        for (int value : count) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }
}
