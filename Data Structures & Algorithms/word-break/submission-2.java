class Solution {

    private Map<Integer, Boolean> memo;


    public boolean wordBreak(String expression, List<String> wordDictionary) {
        memo = new HashMap<>();
        memo.put(expression.length(), true);
        return depthFirstSearch(expression, wordDictionary, 0);
    }

    private boolean depthFirstSearch(String expression, List<String> wordDictionary, int index) {
        if (index == expression.length()) {
            return true;
        }
        if (memo.containsKey(index)) {
            return memo.get(index);
        }

        for (String word : wordDictionary) {
            if (index + word.length() <= expression.length() && expression.substring(index, index + word.length()).equals(word)) {
                if (depthFirstSearch(expression, wordDictionary, index + word.length())) {
                    memo.put(index, true);
                    return true;
                }
            }
        }
        memo.put(index, false);
        return false;
    }
}
