class Solution {

    public int tribonacci(int number) {
        int[] dp = {0, 1, 1};
        if (number < 3) {
            return dp[number];
        }
        for (int index = 3; index <= number; ++index) {
            dp[index % 3] = dp[0] + dp[1] + dp[2];
        }
        return dp[number % 3];
    }
}