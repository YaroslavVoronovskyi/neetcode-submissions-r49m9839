class Solution {
    public int missingNumber(int[] numbers) {
        int size = numbers.length;
        int xor = size;
        for (int index = 0; index < size; index++) {
            xor ^= index ^ numbers[index];
        }
        return xor;
    }
}
