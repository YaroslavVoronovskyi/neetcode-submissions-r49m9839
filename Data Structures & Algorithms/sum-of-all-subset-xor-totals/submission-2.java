class Solution {

    public int subsetXORSum(int[] numbers) {
        int size = numbers.length;
        int result = 0;
        for (int mask = 0; mask < (1 << size); mask++) {
            int xorr = 0;
            for (int index = 0; index < size; index++) {
                if ((mask & (1 << index)) != 0) {
                    xorr ^= numbers[index];
                }
            }
            result += xorr;
        }
        return result;
    }
}