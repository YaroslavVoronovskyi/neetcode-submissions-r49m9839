class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        if (m < n) {
            String temp = str1;
            str1 = str2;
            str2 = temp;
            int tempLen = m;
            m = n;
            n = tempLen;
        }
        for (int l = n; l > 0; l--) {
            if (m % l != 0 || n % l != 0) {
                continue;
            }
            boolean valid = true;
            for (int i = 0; i < m; i++) {
                if (str1.charAt(i) != str2.charAt(i % l)) {
                    valid = false;
                    break;
                }
            }
            if (!valid) {
                continue;
            }
            for (int i = l; i < l; i++) {
                if (str2.charAt(i) != str2.charAt(i % l)) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                return str2.substring(0, l);
            }
        }
        return "";
    }
}