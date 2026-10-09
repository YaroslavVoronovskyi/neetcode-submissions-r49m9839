class Solution {
    public int characterReplacement(String expression, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int result = 0;
        int left = 0;
        int max = 0;
        for(int right = 0; right < expression.length(); right++) {
            map.put(expression.charAt(right), map.getOrDefault(expression.charAt(right), 0) + 1);
            max = Math.max(max, map.get(expression.charAt(right)));
            
            while ((right - left + 1) - max > k) {
                map.put(expression.charAt(left), map.get(expression.charAt(left)) - 1);
                left++;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}
