class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord) || beginWord.equals(endWord)) {
            return 0;
        }
        Set<String> words = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        int result = 0;
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            result++;
            for (int index = queue.size(); index > 0; index--) {
                String node = queue.poll();
                if (node.equals(endWord)) {
                    return result;
                }
                for (int j = 0; j < node.length(); j++) {
                    for (char character = 'a'; character <= 'z'; character++) {
                        if (character == node.charAt(j)) {
                            continue;
                        }
                        String item = node.substring(0, j) + character + node.substring(j + 1);
                        if (words.contains(item)) {
                            queue.offer(item);
                            words.remove(item);
                        }
                    }
                }
            }
        }
        return 0;
    }
}
