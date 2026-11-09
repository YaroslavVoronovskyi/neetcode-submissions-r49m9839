class Solution {
    public int climbStairs(int number) {
        int one = 1;
        int two = 1;
        for (int index = 0; index < number - 1; index++) {
            int temp = one;
            one = one + two;
            two = temp;
        }
        return one;
    }
}
