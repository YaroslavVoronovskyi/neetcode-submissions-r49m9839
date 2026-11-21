class Solution {
    public boolean isAnagram(String expression, String target) {
        if (expression.length() != target.length()) {
            return false;
        }
        Map<Character, Integer> first = new HashMap<>();
        Map<Character, Integer> second = new HashMap<>();
        for (int index = 0; index < expression.length(); index++) {
            first.put(expression.charAt(index), first.getOrDefault(expression.charAt(index), 0) + 1);
            second.put(target.charAt(index), second.getOrDefault(target.charAt(index), 0) + 1);
        }
        return first.equals(second);
    }
}
