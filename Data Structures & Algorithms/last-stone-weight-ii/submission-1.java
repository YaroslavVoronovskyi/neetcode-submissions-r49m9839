class Solution {
    public int lastStoneWeightII(int[] stones) {
        int stoneSum = 0;
        for (int stone : stones) {
            stoneSum += stone;
        }
        int target = stoneSum / 2;
        int[] dp = new int[target + 1];

        for (int stone : stones) {
            for (int item = target; item >= stone; item--) {
                dp[item] = Math.max(dp[item], dp[item - stone] + stone);
            }
        }
        return stoneSum - 2 * dp[target];
    }
}