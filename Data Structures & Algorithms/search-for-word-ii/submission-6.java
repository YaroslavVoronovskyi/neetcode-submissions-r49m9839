class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();

        // Build Trie
        for (String word : words) {
            TrieNode curr = root;

            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';

                if (curr.children[idx] == null) {
                    curr.children[idx] = new TrieNode();
                }

                curr = curr.children[idx];
            }

            curr.word = word;
        }

        List<String> result = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, result);
            }
        }

        return result;
    }

    private void dfs(char[][] board, int r, int c,
                     TrieNode parent, List<String> result) {

        char ch = board[r][c];
        int idx = ch - 'a';

        if (ch == '#' || parent.children[idx] == null) {
            return;
        }

        TrieNode node = parent.children[idx];

        // Word found
        if (node.word != null) {
            result.add(node.word);
            node.word = null; // Avoid duplicates
        }

        // Mark visited
        board[r][c] = '#';

        // Explore four directions
        if (r > 0)
            dfs(board, r - 1, c, node, result);

        if (r < board.length - 1)
            dfs(board, r + 1, c, node, result);

        if (c > 0)
            dfs(board, r, c - 1, node, result);

        if (c < board[0].length - 1)
            dfs(board, r, c + 1, node, result);

        // Backtrack
        board[r][c] = ch;

        // Prune empty Trie branches
        boolean empty = node.word == null;

        for (TrieNode child : node.children) {
            if (child != null) {
                empty = false;
                break;
            }
        }

        if (empty) {
            parent.children[idx] = null;
        }
    }
}
