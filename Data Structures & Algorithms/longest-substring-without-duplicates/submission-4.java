class Solution {
    public int lengthOfLongestSubstring(String expression) {
        Set<Character> set = new HashSet<>();
        int result = 0;
        int left = 0;
        for (int right = 0; right < expression.length(); right++) {
            while (set.contains(expression.charAt(right))) {
                set.remove(expression.charAt(left));
                left++;
            }
            set.add(expression.charAt(right));
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}
