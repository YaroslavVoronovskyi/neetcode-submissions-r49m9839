class Solution {
    public boolean isAnagram(String expression, String target) {
        if (expression.length() != target.length()) {
            return false;
        }
        Map<Character, Integer> expressionMap = new HashMap<>();
        Map<Character, Integer> targetMap = new HashMap<>();
        for (int index = 0; index < expression.length(); index++) {
            expressionMap.put(expression.charAt(index), expressionMap.getOrDefault(expression.charAt(index), 0) + 1);
            targetMap.put(target.charAt(index), targetMap.getOrDefault(target.charAt(index), 0) + 1);
        }
        return expressionMap.equals(targetMap);
    }
}
