public class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean endOfWord = false;
}

class PrefixTree {

    private TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (char character : word.toCharArray()) {
            int index = character - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.endOfWord = true;
    }

    public boolean search(String word) {
        TrieNode current = root;
        for (char character : word.toCharArray()) {
            int index = character - 'a';
            if (current.children[index] == null) {
                return false;
            }
            current = current.children[index];
        }
        return current.endOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (char character : prefix.toCharArray()) {
            int index = character - 'a';
            if (current.children[index] == null) {
                return false;
            }
            current = current.children[index];
        }
        return true;
    }
}
