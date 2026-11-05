class Solution {
    private Map<Character, Set<Character>> adjacency;
    private Map<Character, Boolean> visited;
    private List<Character> result;

    public String foreignDictionary(String[] words) {
        adjacency = new HashMap<>();
        for (String word : words) {
            for (char character : word.toCharArray()) {
                adjacency.putIfAbsent(character, new HashSet<>());
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
                    adjacency.get(w1.charAt(inner)).add(w2.charAt(inner));
                    break;
                }
            }
        }

        visited = new HashMap<>();
        result = new ArrayList<>();

        for (char character : adjacency.keySet()) {
            if (depthFirstSearch(character)) {
                return "";
            }
        }

        Collections.reverse(result);
        StringBuilder builder = new StringBuilder();
        for (char character : result) {
            builder.append(character);
        }
        return builder.toString();
    }

    private boolean depthFirstSearch(char character) {
        if (visited.containsKey(character)) {
            return visited.get(character);
        }
        visited.put(character, true);
        for (char next : adjacency.get(character)) {
            if (depthFirstSearch(next)) {
                return true;
            }
        }
        visited.put(character, false);
        result.add(character);
        return false;
    }
}
