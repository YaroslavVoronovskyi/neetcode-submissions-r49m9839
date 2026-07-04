class Solution {

    public int tribonacci(int number) {
        if (number <= 2) {
            return number == 0 ? 0 : 1;
        }
        int[] dp = new int[number + 1];
        dp[1] = dp[2] = 1;
        for (int index = 3; index <= number; index++) {
            dp[index] = dp[index - 1] + dp[index - 2] + dp[index - 3];
        }
        return dp[number];
    }
}