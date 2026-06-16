class Solution {
    

    public String foreignDictionary(String[] words) {
        Map<Character, Set<Character>> map = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();
        for (String word : words) {
            for (char character : word.toCharArray()) {
                map.putIfAbsent(character, new HashSet());
                indegree.putIfAbsent(character, 0);
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            int minLen = Math.min(w1.length(), w2.length());
            if (w1.length() > w2.length() && w1.substring(0, minLen).equals(w2.substring(0, minLen))) {
                return "";
            }
            for (int j = 0; j < minLen; j++) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    if (!map.get(w1.charAt(j)).contains(w2.charAt(j))) {
                        map.get(w1.charAt(j)).add(w2.charAt(j));
                        indegree.put(w2.charAt(j), indegree.get(w2.charAt(j)) + 1);
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
            for (char neighbor : map.get(character)) {
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
