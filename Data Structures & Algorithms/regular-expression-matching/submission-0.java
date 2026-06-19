class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        return depthFirstSearch(0, 0, s, p, m, n);
    }

    private boolean depthFirstSearch(int i, int j, String s, String p, int m, int n) {
        if (j == n) {
            return i == m;
        }
        boolean match = i < m && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        if (j + 1 < n && p.charAt(j + 1) == '*') {
            return depthFirstSearch(i, j + 2, s, p, m, n) || (match && depthFirstSearch(i + 1, j, s, p, m, n));
        }
        if (match) {
            return depthFirstSearch(i + 1, j + 1, s, p, m, n);
        }
        return false;
    }
}
