class Solution {

    public int subsetXORSum(int[] numbers) {
        int result = 0;
        for (int number : numbers) {
            result |= number;
        }
        return result << (numbers.length - 1);
    }
}