class Solution {
    public void reverseString(char[] s) {
        char[] result = new char[s.length];
        for (int i = s.length - 1, j = 0; i >= 0; i--, j++) {
            result[j] = s[i]; 
        }
        System.arraycopy(result, 0, s, 0, s.length);
    }
}