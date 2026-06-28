class Solution {
    public void reverseString(char[] s) {
        char[] result = new char[s.length];
        for (int i = s.length - 1, j = 0; i >= 0; i--, j++) {
            result[j] = s[i]; 
        }
        for (int i = 0; i < s.length; i++) {
            s[i] = result[i];
        }
    }
}