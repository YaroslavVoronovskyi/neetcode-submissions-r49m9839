class Solution {
    public List<Integer> partitionLabels(String expression) {
        Map<Character, Integer> lastIndexes = new HashMap<>();
        for (int index = 0; index < expression.length(); index++) {
            lastIndexes.put(expression.charAt(index), index);
        }

        List<Integer> result = new ArrayList<>();
        int size = 0;
        int end = 0;
        for (int index = 0; index < expression.length(); index++) {
            size++;
            end = Math.max(end, lastIndexes.get(expression.charAt(index)));

            if (index == end) {
                result.add(size);
                size = 0;
            }
        }
        return result;
    }
}
