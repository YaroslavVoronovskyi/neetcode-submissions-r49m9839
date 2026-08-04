class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        Set<String> words = new HashSet<>(Arrays.asList(dictionary));
        int size = s.length();
        int[] dp = new int[size + 1];
        Arrays.fill(dp, -1);
        dp[size] = 0;
        return depthFirstSearch(0, s, words, dp);
    }

    private int depthFirstSearch(int i, String s, Set<String> words, int[] dp) {
        if (dp[i] != -1) {
            return dp[i];
        }
        int result = 1 + depthFirstSearch(i + 1, s, words, dp);
        for (int j = i; j < s.length(); j++) {
            if (words.contains(s.substring(i, j + 1))) {
                result = Math.min(result, depthFirstSearch(j + 1, s, words, dp));
            }
        }
        dp[i] = result;
        return result;
    }
}