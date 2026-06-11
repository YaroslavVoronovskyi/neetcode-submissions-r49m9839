class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord) || beginWord.equals(endWord)) {
            return 0;
        }
        Map<String, List<String>> map = new HashMap<>();
        wordList.add(beginWord);
        for (String word : wordList) {
            for (int j = 0; j < word.length(); j++) {
                String pattern = word.substring(0, j) + "*" + word.substring(j + 1);
                map.computeIfAbsent(pattern, key -> new ArrayList<>()).add(word);
            }
        }
        Set<String> visit = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        int result = 1;
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int index = 0; index < size; index++) {
                String word = queue.poll();
                if (word.equals(endWord)) {
                    return result;
                }
                for (int j = 0; j < word.length(); j++) {
                    String pattern = word.substring(0, j) + "*" + word.substring(j + 1);
                    for (String item : map.getOrDefault(pattern, Collections.emptyList())) {
                        if (!visit.contains(item)) {
                            visit.add(item);
                            queue.offer(item);
                        }
                    }
                }
            }
            result++;
        }
        return 0;
    }
}
