class Solution {
    public int lengthOfLongestSubstring(String expression) {
        int result = 0;
        for (int i = 0; i < expression.length(); i++) {
            Set<Character> set = new HashSet<>();
            for (int j = i; j < expression.length(); j++) {
                if (set.contains(expression.charAt(j))) {
                    break;
                }
                set.add(expression.charAt(j));
            } 
            result = Math.max(result, set.size());
        }
        return result;
    }
}
