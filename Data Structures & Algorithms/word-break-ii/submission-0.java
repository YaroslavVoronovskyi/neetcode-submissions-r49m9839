class Solution {

    private Set<String> wordSet;
    private List<String> result;

    public List<String> wordBreak(String s, List<String> wordDict) {
        wordSet = new HashSet<>(wordDict);
        result = new ArrayList<>();
        List<String> current = new ArrayList<>();
        backtrack(s, 0, current);
        return result;
    }

    private void backtrack(String s, int i, List<String> current) {
        if (i == s.length()) {
            result.add(String.join(" ", current));
            return;
        }
        for (int j = i; j < s.length(); j++) {
            String word = s.substring(i, j + 1);
            if (wordSet.contains(word)) {
                current.add(word);
                backtrack(s, j + 1, current);
                current.remove(current.size() - 1);
            }
        }
    }
}