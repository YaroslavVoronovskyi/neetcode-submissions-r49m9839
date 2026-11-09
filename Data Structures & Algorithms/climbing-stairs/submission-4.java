class Solution {
    public int climbStairs(int number) {
        if (number <= 2) {
            return number;
        }
        int[] cache = new int[number + 1];
        cache[1] = 1;
        cache[2] = 2;
        for (int index = 3; index <= number; index++) {
            cache[index] = cache[index - 1] + cache[index - 2];
        }
        return cache[number];
    }
}
