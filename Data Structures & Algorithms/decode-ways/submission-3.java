class Solution {
    public int numDecodings(String expression) {
        int size = expression.length();
        int dp = 0;
        int dp1 = 1;
        int dp2 = 0;
        for (int index = size - 1; index >= 0; index--) {
            if (expression.charAt(index) == '0') {
                dp = 0;
            } else {
                dp = dp1;
                if (index + 1 < expression.length() && (expression.charAt(index) == '1' ||
                    expression.charAt(index) == '2' && expression.charAt(index + 1) < '7')) {
                    dp += dp2;
                }
            }
            dp2 = dp1;
            dp1 = dp;
            dp = 0;
        }
        return dp1;
    }
}
