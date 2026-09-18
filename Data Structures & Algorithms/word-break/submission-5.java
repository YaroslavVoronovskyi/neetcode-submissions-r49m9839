class Solution {

    public boolean wordBreak(String expression, List<String> wordDictionary) {
        boolean[] dp = new boolean[expression.length() + 1];
        dp[expression.length()] = true;

        for (int index = expression.length() - 1; index >= 0; index--) {
            for (String word : wordDictionary) {
                if ((index + word.length()) <= expression.length() && 
                    expression.substring(index , index + word.length()).equals(word)) {
                        dp[index] = dp[index + word.length()];
                }
                if (dp[index]) {
                    break;
                }
            }
        }
        return dp[0];
    }
}
