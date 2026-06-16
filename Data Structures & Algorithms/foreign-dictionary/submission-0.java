class Solution {
    private Map<Character, Set<Character>> map;
    private Map<Character, Boolean> visited;
    private List<Character> result;

    public String foreignDictionary(String[] words) {
        map = new HashMap<>();
        for (String word : words) {
            for (char character : word.toCharArray()) {
                map.putIfAbsent(character, new HashSet());
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
                    map.get(w1.charAt(j)).add(w2.charAt(j));
                    break;
                }
            }
        }
        visited = new HashMap<>();
        result = new ArrayList<>();
        for (char character : map.keySet()) {
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
        for (char next : map.get(character)) {
            if (depthFirstSearch(next)) {
                return true;
            }
        }
        visited.put(character, false);
        result.add(character);
        return false;
    }
}
