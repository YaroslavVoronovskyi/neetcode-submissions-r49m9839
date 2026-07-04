class Solution {

    public int tribonacci(int number) {
        if (number <= 2) {
            return number == 0 ? 0 : 1;
        }
        int[] dp = {0, 1, 1};
        for (int index = 3; index <= number; ++index) {
            dp[index % 3] = dp[0] + dp[1] + dp[2];
        }
        return dp[number % 3];
    }
}