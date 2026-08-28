class Solution {

    private Set<Integer> cols = new HashSet<>();
    private Set<Integer> posDiag = new HashSet<>();
    private Set<Integer> negDiag = new HashSet<>();
    private int result;

    public int totalNQueens(int n) {
        result = 0;
        backtrack(0, n);
        return result;
    }

    private void backtrack(int row, int n) {
        if (row == n) {
            result++;
            return;
        }
        for (int col = 0; col < n; col++) {
            if (cols.contains(col) || posDiag.contains(row + col) || negDiag.contains(row - col)) {
                continue;
            }
            cols.add(col);
            posDiag.add(row + col);
            negDiag.add(row - col);
            backtrack(row + 1, n);
            cols.remove(col);
            posDiag.remove(row + col);
            negDiag.remove(row - col);
        }
    }
}