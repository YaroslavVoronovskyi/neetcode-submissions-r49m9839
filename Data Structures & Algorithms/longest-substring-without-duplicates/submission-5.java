class Solution {
    public int lengthOfLongestSubstring(String expression) {
        Map<Character, Integer> map = new HashMap<>();
        int result = 0;
        int left = 0;
        for (int right = 0; right < expression.length(); right++) {
            if (map.containsKey(expression.charAt(right))) {
                left = Math.max(map.get(expression.charAt(right)) + 1, left);
            }
            map.put(expression.charAt(right), right);
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}
