class Solution {
    public int[] countBits(int number) {
        int[] result = new int[number + 1];
        int offset = 1;
        for (int index = 1; index <= number; index++) {
            if (offset * 2 == index) {
                offset = index;
            }
            result[index] = 1 + result[index - offset];
        }
        return result;
    }
}
