class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, Set<Character>> adjacency = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        for (String word : words) {
            for (char character : word.toCharArray()) {
                adjacency.putIfAbsent(character, new HashSet<>());
                indegree.putIfAbsent(character, 0);
            }
        }

        for (int outer = 0; outer < words.length - 1; outer++) {
            String w1 = words[outer];
            String w2 = words[outer + 1];
            int minLength = Math.min(w1.length(), w2.length());
            if (w1.length() > w2.length() && 
                w1.substring(0, minLength).equals(w2.substring(0, minLength))) {
                return "";
            }
            for (int inner = 0; inner < minLength; inner++) {
                if (w1.charAt(inner) != w2.charAt(inner)) {
                    if (!adjacency.get(w1.charAt(inner)).contains(w2.charAt(inner))) {
                        adjacency.get(w1.charAt(inner)).add(w2.charAt(inner));
                        indegree.put(w2.charAt(inner), indegree.get(w2.charAt(inner)) + 1);
                    }
                    break;
                }
            }
        }

        Queue<Character> queue = new LinkedList<>();
        for (char character : indegree.keySet()) {
            if (indegree.get(character) == 0) {
                queue.offer(character);
            }
        }

        StringBuilder result = new StringBuilder();
        while (!queue.isEmpty()) {
            char character = queue.poll();
            result.append(character);
            for (char neighbor : adjacency.get(character)) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if (indegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        if (result.length() != indegree.size()) {
            return "";
        }
        return result.toString();
    }
}
