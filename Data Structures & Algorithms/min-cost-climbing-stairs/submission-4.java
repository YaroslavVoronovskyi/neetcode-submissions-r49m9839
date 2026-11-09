class Solution {
    public int minCostClimbingStairs(int[] cost) {
        for (int index = cost.length - 3; index >= 0; index--) {
            cost[index] += Math.min(cost[index + 1], cost[index + 2]);
        }
        return Math.min(cost[0], cost[1]);
    }
}
