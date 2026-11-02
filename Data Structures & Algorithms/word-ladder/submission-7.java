class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }

        Map<String, List<String>> map = new HashMap<>();
        wordList.add(beginWord);

        for (String word : wordList) {
            for (int index = 0; index < word.length(); index++) {
                String pattern = word.substring(0, index) + "*" + word.substring(index + 1);
                map.computeIfAbsent(pattern, key -> new ArrayList<>()).add(word);
            }
        }

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int result = 1;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int outer = 0; outer < size; outer++) {
                String word = queue.poll();
                if (word.equals(endWord)) {
                    return result;
                }
                for (int inner = 0; inner < word.length(); inner++) {
                    String pattern = word.substring(0, inner) + "*" + word.substring(inner + 1);
                    for (String entry : map.getOrDefault(pattern, List.of())) {
                        if (!visited.contains(entry)) {
                            visited.add(entry);
                            queue.offer(entry);
                        }
                    }
                }
            }
            result++;
        }
        return 0;
    }
}
