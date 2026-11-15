class Solution {
    public int singleNumber(int[] numbers) {
        int result = 0;
        for (int number : numbers) {
            result ^= number;
        }
        return result;
    }
}
