class Solution {
    public int missingNumber(int[] numbers) {
        int size = numbers.length;
        int xorr = size;
        for (int index = 0; index < size; index++) {
            xorr ^= index ^ numbers[index];
        }
        return xorr;
    }
}
