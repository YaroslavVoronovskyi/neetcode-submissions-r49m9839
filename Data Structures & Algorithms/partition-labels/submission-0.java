class Solution {
    public List<Integer> partitionLabels(String expression) {
        Map<Character, Integer> lastIndex = new HashMap<>();
        for (int index = 0; index < expression.length(); index++) {
            lastIndex.put(expression.charAt(index), index);
        }

        List<Integer> result = new ArrayList<>();
        int size = 0;
        int end = 0;
        for (int index = 0; index < expression.length(); index++) {
            size++;
            end = Math.max(end, lastIndex.get(expression.charAt(index)));
            if (index == end) {
                result.add(size);
                size = 0;
            }
        }
        return result;
    }
}
