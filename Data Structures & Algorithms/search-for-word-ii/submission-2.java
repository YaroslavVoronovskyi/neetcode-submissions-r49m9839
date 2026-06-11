class TrieNode {
    Map<Character, TrieNode> children;
    boolean isWord;

    public TrieNode() {
        children = new HashMap<>();
        isWord = false;
    }

    public void addWord(String word) {
        TrieNode current = this;
        for (char character : word.toCharArray()) {
            current.children.putIfAbsent(character, new TrieNode());
            current = current.children.get(character);
        }
        current.isWord = true;
    }
}

class Solution {

    private Set<String> result;
    private boolean[][] visit;

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            root.addWord(word);
        }
        int rows = board.length;
        int cols = board[0].length;
        result = new HashSet<>();
        visit = new boolean[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                depthFirstSearch(board, row, col, root, "");
            }
        }
        return new ArrayList<>(result);
    }

    private void depthFirstSearch(char[][] board, int row, int col, TrieNode node, String word) {
        int rows = board.length;
        int cols = board[0].length;

        if (row < 0 || col < 0 || row >= rows || col >= cols || visit[row][col] 
                    || !node.children.containsKey(board[row][col])) {
            return;
        }
        visit[row][col] = true;
        node = node.children.get(board[row][col]);
        word += board[row][col];
        if (node.isWord) {
            result.add(word);
        }

        depthFirstSearch(board, row + 1, col, node, word);
        depthFirstSearch(board, row - 1, col, node, word);
        depthFirstSearch(board, row, col + 1, node, word);
        depthFirstSearch(board, row, col - 1, node, word);

        visit[row][col] = false;
    }
}
