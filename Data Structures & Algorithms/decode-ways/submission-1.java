class Solution {
    public int numDecodings(String expression) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(expression.length(), 1);
        return depthFirstSearch(expression, 0, map);
    }

    private int depthFirstSearch(String expression, int index, Map<Integer, Integer> map) {
        if (map.containsKey(index)) {
            return map.get(index);
        }
        if (index == expression.length()) {
            return 1;
        }
        if (expression.charAt(index) == '0') {
            return 0;
        }
        int result = depthFirstSearch(expression, index + 1, map);
        if (index + 1 < expression.length() && (expression.charAt(index) == '1' || 
            expression.charAt(index) == '2' && expression.charAt(index + 1) < '7')) {
            result += depthFirstSearch(expression, index + 2, map);
        }
        map.put(index, result);
        return result;
    }
}
