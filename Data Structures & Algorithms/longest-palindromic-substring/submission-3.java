class Solution {
    public String longestPalindrome(String expression) {
        int resIdx = 0;
        int resLen = 0;
        int size = expression.length();
        
        for (int i = 0; i < size; i++) {
            int left = i;
            int right = i;
            while (left >= 0 && right < size && expression.charAt(left) == expression.charAt(right)) {
                if (right - left + 1 > resLen) {
                    resIdx = left;
                    resLen = right - left + 1;
                }
                left--;
                right++;
            }
            left = i;
            right = i + 1;
            while (left >= 0 && right < size && expression.charAt(left) == expression.charAt(right)) {
                if (right - left + 1 > resLen) {
                    resIdx = left;
                    resLen = right - left + 1;
                }
                left--;
                right++;
            }
        }
        return expression.substring(resIdx, resIdx + resLen);
    }
}
