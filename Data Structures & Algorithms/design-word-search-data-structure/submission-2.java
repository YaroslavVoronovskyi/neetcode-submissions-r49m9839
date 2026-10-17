
class WordDictionary {

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode current = root;
        for (char character : word.toCharArray()) {
            if (current.children[character - 'a'] == null) {
                current.children[character - 'a'] = new TrieNode();
            }
            current = current.children[character - 'a'];
        }
        current.endOfWord = true;
    }

    public boolean search(String word) {
        return depthFirstSearch(word, 0, root);
    }

    private boolean depthFirstSearch(String word, int j, TrieNode root) {
        TrieNode current = root;
        for (int i = j; i < word.length(); i++) {
            char character = word.charAt(i);
            if (character == '.') {
                for (TrieNode child : current.children) {
                    if (child != null && depthFirstSearch(word, i + 1, child)) {
                        return true;
                    }
                }
                return false;
            } else {
                if (current.children[character - 'a'] == null) {
                    return false;
                }
                current = current.children[character - 'a'];
            }
        }
        return current.endOfWord;
    }
}

public class TrieNode {
    TrieNode[] children;
    boolean endOfWord;

    public TrieNode() {
        children = new TrieNode[26];
        endOfWord = false;
    }
}
