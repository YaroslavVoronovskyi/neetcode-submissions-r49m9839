class Solution {
    public int climbStairs(int number) {
        if (number <= 2) {
            return number;
        }
        int[] array = new int[number + 1];
        array[1] = 1;
        array[2] = 2;
        for (int index = 3; index <= number; index++) {
            array[index] = array[index - 1] + array[index - 2];
        }
        return array[number];
    }
}
