class Solution {
    int[] cache;
    public int climbStairs(int number) {
       cache = new int[number];
       for (int index = 0; index < number; index++) {
        cache[index] = -1;
       }
       return depthFirstSearch(number, 0);
    }

    private int depthFirstSearch(int number, int level) {
        if (level >= number) {
            return level == number ? 1 : 0;
        }
        if (cache[level] != -1) {
            return cache[level];
        }
        return cache[level] = depthFirstSearch(number, level + 1) + depthFirstSearch(number, level + 2);
    }
}
