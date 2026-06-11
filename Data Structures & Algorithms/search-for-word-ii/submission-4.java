class TrieNode {
    TrieNode[] children = new TrieNode[26];
    int idx = -1;
    int refs = 0;

    public void addWord(String word, int i) {
        TrieNode current = this;
        current.refs++;
        for (char character : word.toCharArray()) {
            int index = character - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
            current.refs++;
        }
        current.idx = i;
    }
}

class Solution {

    List<String> result = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for (int index = 0; index < words.length; index++) {
            root.addWord(words[index], index);
        }
      
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                depthFirstSearch(board, root, row, col, words);               
            }
        }
        return result;
    }

    private void depthFirstSearch(char[][] board, TrieNode node, int row, int col, String[] words) {
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] == '*' ||
        node.children[board[row][col] - 'a'] == null) {
            return;
        }
        char temp = board[row][col];
        board[row][col] = '*';
        TrieNode prev = node;
        node = node.children[temp - 'a'];
        if (node.idx != -1) {
            result.add(words[node.idx]);
            node.idx = -1;
            node.refs--;
            if (node.refs == 0) {
                node = null;
                prev.children[temp - 'a'] = null;
                board[row][col] = temp;
                return;
            }
        }
        depthFirstSearch(board, node, row + 1, col, words);
        depthFirstSearch(board, node, row - 1, col, words);
        depthFirstSearch(board, node, row, col + 1, words);
        depthFirstSearch(board, node, row, col - 1, words);
        board[row][col] = temp;
    }
}
