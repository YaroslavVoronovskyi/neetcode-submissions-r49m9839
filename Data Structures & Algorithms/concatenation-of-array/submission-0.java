class Solution {
    public int[] getConcatenation(int[] numbers) {
        int[] result = new int[2 * numbers.length];
        int idx = 0;
        for (int index = 0; index < 2; index++) {
            for (int number : numbers) {
                result[idx++] = number;
            }
        }
        return result;
    }
}