class Solution {
    public List<List<String>> groupAnagrams(String[] expressions) {
        Map<String, List<String>> result = new HashMap<>();
        for (String expression : expressions) {
            char[] charArray = expression.toCharArray();
            Arrays.sort(charArray);
            String sortedExpression = new String(charArray);
            result.putIfAbsent(sortedExpression, new ArrayList<>());
            result.get(sortedExpression).add(expression);
       }
       return new ArrayList<>(result.values());
    }
}
