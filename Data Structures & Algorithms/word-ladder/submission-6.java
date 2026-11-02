class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord) || beginWord.equals(endWord)) {
            return 0;
        }

        int n = wordList.size();
        int m = wordList.get(0).length();
        List<List<Integer>> adjacencyList = new ArrayList<>(n);
        for (int index = 0; index < n; index++) {
            adjacencyList.add(new ArrayList<>());
        }

        Map<String, Integer> map = new HashMap<>();
        for (int index = 0; index < n; index++) {
            map.put(wordList.get(index), index);
        }

        for (int outer = 0; outer < n; outer++) {
            for (int inner = outer + 1; inner < n; inner++) {
                int count = 0;
                for (int key = 0; key < m; key++) {
                    if (wordList.get(outer).charAt(key) != wordList.get(inner).charAt(key)) {
                        count++;
                    }
                }
                if (count == 1) {
                    adjacencyList.get(outer).add(inner);
                    adjacencyList.get(inner).add(outer);
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        int result = 1;
        Set<Integer> visited = new HashSet<>();

        for (int index = 0; index < m; index++) {
            for (char character = 'a'; character <= 'z'; character++) {
                if (character == beginWord.charAt(index)) {
                    continue;
                }
                String word = beginWord.substring(0, index) + character + beginWord.substring(index + 1);
                if (map.containsKey(word) && !visited.contains(map.get(word))) {
                    queue.add(map.get(word));
                    visited.add(map.get(word));
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
                for (int item : adjacencyList.get(node)) {
                    if (!visited.contains(item)) {
                        visited.add(item);
                        queue.add(item);
                    }
                }
            }
        }
        return 0;
    }
}
