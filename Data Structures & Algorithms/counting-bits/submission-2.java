class Solution {
    public int[] countBits(int number) {
        int[] result = new int[number + 1];
        for (int index = 1; index <= number; index++) {
            result[index] = Integer.bitCount(index);
        }
        return result;
    }
}
