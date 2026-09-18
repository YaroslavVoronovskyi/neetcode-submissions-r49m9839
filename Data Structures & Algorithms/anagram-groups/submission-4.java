class Solution {
    public List<List<String>> groupAnagrams(String[] expressions) {
        Map<String, List<String>> result = new HashMap<>();
        for (String expression : expressions) {
            int[] count = new int[26];
            for (char character : expression.toCharArray()) {
                count[character - 'a']++;
            }
            String key = Arrays.toString(count);
            result.putIfAbsent(key, new ArrayList<>());
            result.get(key).add(expression);
       }
       return new ArrayList<>(result.values());
    }
}
