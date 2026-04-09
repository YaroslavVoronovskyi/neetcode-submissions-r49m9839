class Solution {
    public int missingNumber(int[] numbers) {
        int size = numbers.length;
        int result = size;
        for (int index = 0; index < numbers.length; index++) {
            result ^= index ^ numbers[index];
        }
        return result;
    }
}
