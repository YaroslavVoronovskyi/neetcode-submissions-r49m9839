class Solution {

    private Boolean[][] array;



    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        if (m + n != s3.length()) {
            return false;
        }
        array = new Boolean[m + 1][n + 1];
        return depthFirstSearch(0, 0, 0, s1, s2, s3);
    }

    private boolean depthFirstSearch(int i, int j, int k, String s1, String s2, String s3) {
        if (k == s3.length()) {
            return (i == s1.length()) && (j == s2.length());
        }
        if (array[i][j] != null) {
            return array[i][j];
        }
        boolean result = false;
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            result = (depthFirstSearch(i + 1, j, k + 1, s1, s2, s3));
        }

        if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            result = (depthFirstSearch(i, j + 1, k + 1, s1, s2, s3));
        }
        array[i][j] = result;
        return result;
    }
}
