class Solution {

    public int subsetXORSum(int[] numbers) {
        int size = numbers.length;
        int result = 0;
        for (int number : numbers) {
            result |= number;
        }
        return result << (size - 1);
    }
}