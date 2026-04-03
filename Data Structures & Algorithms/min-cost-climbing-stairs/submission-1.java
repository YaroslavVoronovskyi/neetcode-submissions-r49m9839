class Solution {
    int[] memo;
    public int minCostClimbingStairs(int[] cost) {
        memo = new int[cost.length];
        Arrays.fill(memo, -1);
        return Math.min(depthFirstSearch(cost, 0), depthFirstSearch(cost, 1));
    }

    private int depthFirstSearch(int[] cost, int level) {
        if (level >= cost.length) {
            return 0;
        }
        if (memo[level] != -1) {
            return memo[level];
        }
        memo[level] = cost[level] + Math.min(depthFirstSearch(cost, level + 1), depthFirstSearch(cost, level + 2));
        return memo[level];
    }
}
