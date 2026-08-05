class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(s.length(), 0);
        return depthFirstSearch(0, s, dictionary, dp);
    }

    private int depthFirstSearch(int i, String s, String[] dictionary, Map<Integer, Integer> dp) {
        if (dp.containsKey(i)) {
            return dp.get(i);
        }
        int result = 1 + depthFirstSearch(i + 1, s, dictionary, dp);
        for (String word : dictionary) {
            if (i + word.length() > s.length()) {
                continue;
            }
            boolean flag = true;
            for (int j = 0; j < word.length(); j++) {
                if (s.charAt(i + j) != word.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result = Math.min(result, depthFirstSearch(i + word.length(), s, dictionary, dp));
            }
        }
        dp.put(i, result);
        return result;
    }
}