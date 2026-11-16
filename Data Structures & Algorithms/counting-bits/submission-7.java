class Solution {
    public int[] countBits(int number) {
        int[] result = new int[number + 1];
        for (int index = 1; index <= number; index++) {
            result[index] = result[index >> 1] + (index & 1);
        }
        return result;
    }
}
