class Solution {

    private Set<String> wordSet;
    private Boolean[] memo;
    private int number;


    public boolean wordBreak(String expression, List<String> wordDictionary) {
        wordSet = new HashSet<>(wordDictionary);
        memo = new Boolean[expression.length()];
        number = 0;
        for (int index = 0; index < wordDictionary.size(); index++) {
            number = Math.max(number, wordDictionary.get(index).length());
        }
        return depthFirstSearch(expression, 0);
    }

    private boolean depthFirstSearch(String expression, int index) {
        if (index == expression.length()) {
            return true;
        }
        if (memo[index] != null) {
            return memo[index];
        }

        for (int j = index; j < Math.min(index + number, expression.length()); j++) {
            if (wordSet.contains(expression.substring(index, j + 1))) {
                if (depthFirstSearch(expression, j + 1)) {
                    memo[index] = true;
                    return true;
                }
            }
        }
        memo[index] = false;
        return false;
    }
}
