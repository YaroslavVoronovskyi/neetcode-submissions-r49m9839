class Solution {
    public int integerBreak(int number) {
        int[] dp = new int[number + 1];
        dp[1] = 1;

        for (int index = 2; index <= number; index++) {
            dp[index] = (index == number) ? 0 : index;
            for (int i = 1; i < index; i++) {
                dp[index] = Math.max(dp[index], dp[i] * dp[index - i]);
            }
        }
        return dp[number];
    }
}