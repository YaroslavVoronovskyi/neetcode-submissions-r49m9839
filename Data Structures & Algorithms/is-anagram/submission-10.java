class Solution {
    public boolean isAnagram(String expression, String target) {
        if (expression.length() != target.length()) {
            return false;
        }

        Map<Character, Integer> first = new HashMap<>();
        for (char character : expression.toCharArray()) {
            first.put(character, first.getOrDefault(character, 0) + 1);
        }
        
        Map<Character, Integer> second = new HashMap<>();
        for (char character : target.toCharArray()) {
            second.put(character, second.getOrDefault(character, 0) + 1);
        }

        return first.equals(second);
    }
}
