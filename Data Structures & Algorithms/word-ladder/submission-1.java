class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord) || beginWord.equals(endWord)) {
            return 0;
        }
        int n = wordList.size();
        int m = wordList.getFirst().length();
        List<List<Integer>> list = new ArrayList<>(n);
        for (int index = 0; index < n; index++) {
            list.add(new ArrayList<>());
        }
        Map<String, Integer> map = new HashMap<>();
        for (int index = 0; index < n; index++) {
            map.put(wordList.get(index), index);
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int count = 0;
                for (int k = 0; k < m; k++) {
                    if (wordList.get(i).charAt(k) != wordList.get(j).charAt(k)) {
                        count++;
                    }
                }
                if (count == 1) {
                    list.get(i).add(j);
                    list.get(j).add(i);
                }
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        int result = 1;
        Set<Integer> visit = new HashSet<>();
        for (int index = 0; index < m; index++) {
            for (char character = 'a'; character <= 'z'; character++) {
                if (character == beginWord.charAt(index)) {
                    continue;
                }
                String word = beginWord.substring(0, index) + character + beginWord.substring(index + 1);
                if (map.containsKey(word) && !visit.contains(map.get(word))) {
                    queue.add(map.get(word));
                    visit.add(map.get(word));
                }
            }
        }
        while (!queue.isEmpty()) {
            result++;
            int size = queue.size();
            for (int index = 0; index < size; index++) {
                int node = queue.poll();
                if (wordList.get(node).equals(endWord)) {
                    return result;
                }
                for (int item : list.get(node)) {
                    if (!visit.contains(item)) {
                        visit.add(item);
                        queue.add(item);
                    }
                }
            }
        }
        return 0;
    }
}
