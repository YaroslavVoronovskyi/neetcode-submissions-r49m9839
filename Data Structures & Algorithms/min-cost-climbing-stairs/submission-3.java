class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int size = cost.length;
        int[] cache = new int[size + 1];
        for (int index = 2; index <= size; index++) {
            cache[index] = Math.min(cache[index - 1] + cost[index - 1], 
                                    cache[index - 2] + cost[index - 2]);
        }
        return cache[size];
    }
}
