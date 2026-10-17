class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode current = root;
            for (char character : word.toCharArray()) {
                int index = character - 'a';
                if (current.children[index] == null) {
                    current.children[index] = new TrieNode();
                }
                current = current.children[index];
            }
            current.word = word;
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                depthFirstSearch(board, i, j, root, result);
            }
        }
        return result;
    }

    private void depthFirstSearch(char[][] board, int row, int col, TrieNode parent, List<String> result) {
        char character = board[row][col];
        int index = character - 'a';
        if (character == '#' || parent.children[index] == null) {
            return;
        }
        TrieNode node = parent.children[index];
        if (node.word != null) {
            result.add(node.word);
            node.word = null;
        }
        board[row][col] = '#';

        if (row > 0) {
            depthFirstSearch(board, row - 1, col, node, result);
        }
        if (row < board.length - 1) {
            depthFirstSearch(board, row + 1, col, node, result);
        }
        if (col > 0) {
            depthFirstSearch(board, row, col - 1, node, result);
        }
        if (col < board[0].length - 1) {
            depthFirstSearch(board, row, col + 1, node, result);
        }

        board[row][col] = character;
        boolean empty = node.word == null;

        for (TrieNode child : node.children) {
            if (child != null) {
                empty = false;
                break;
            }
        }
        if (empty) {
            parent.children[index] = null;
        }
    }
}
