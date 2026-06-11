class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord) || beginWord.equals(endWord)) {
            return 0;
        }
        int m = wordList.getFirst().length();
        Set<String> wordSet = new HashSet<>(wordList);
        Queue<String> qb = new LinkedList<>();
        Queue<String> qe = new LinkedList<>();
        Map<String, Integer> fromBegin = new HashMap<>();
        Map<String, Integer> fromEnd = new HashMap<>();
        qb.add(beginWord);
        qe.add(endWord);
        fromBegin.put(beginWord, 1);
        fromEnd.put(endWord, 1);
        while (!qb.isEmpty() && !qe.isEmpty()) {
            int size = qb.size();
            for (int k = 0; k < size; k++) {
                String word = qb.poll();
                int steps = fromBegin.get(word);
                for (int i = 0; i < m; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == word.charAt(i))
                            continue;
                        String nei = word.substring(0, i) +
                                     c + word.substring(i + 1);
                        if (!wordSet.contains(nei))
                            continue;
                        if (fromEnd.containsKey(nei))
                            return steps + fromEnd.get(nei);
                        if (!fromBegin.containsKey(nei)) {
                            fromBegin.put(nei, steps + 1);
                            qb.add(nei);
                        }
                    }
                }
            }
        }
        return 0;
    }
}
