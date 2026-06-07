public class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean endOfWord = false;
}

class PrefixTree {

    private final TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (char character : word.toCharArray()) {
            current.children.putIfAbsent(character, new TrieNode());
            current = current.children.get(character);
        }
        current.endOfWord = true;
    }

    public boolean search(String word) {
        TrieNode current = root;
        for (char character : word.toCharArray()) {
            if (!current.children.containsKey(character)) {
                return false;
            }
            current = current.children.get(character);
        }
        return current.endOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (char character : prefix.toCharArray()) {
            if (!current.children.containsKey(character)) {
                return false;
            }
            current = current.children.get(character);
        }
        return true;
    }
}
