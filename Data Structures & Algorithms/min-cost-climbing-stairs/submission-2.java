class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int size = cost.length;
        int[] result = new int[size + 1];
        for (int index = 2; index <= size; index++) {
            result[index] = Math.min(result[index - 1] + cost[index -1], result[index - 2] + cost[index - 2]);
        }
        return result[size];
    }
}
