class Solution {

    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        if (m + n != s3.length()) {
            return false;
        }
        if (n < m) {
            String temp = s1;
            s1 = s2;
            s2 = temp;
            int tempLength = m;
            m = n;
            n = tempLength;
        }
        boolean[] array = new boolean[n + 1];
        array[n] = true;
        for (int i = m; i >= 0; i--) {
            boolean next = (i == m ? true : false);
            for (int j = n; j >= 0; j--) {
                boolean result = (j < n ? false : next);
                if (i < m && s1.charAt(i) == s3.charAt(i + j) && array[j]) {
                    result = true;
                }
                if (j < n && s2.charAt(j) == s3.charAt(i + j) && next) {
                    result = true;
                }
                array[j] = result;
                next = array[j];
            }
        }
        return array[0];
    }
}
