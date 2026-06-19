class Solution {
    public int[] getConcatenation(int[] numbers) {
        int size = numbers.length;
        int[] result = new int[size * 2];
        for (int index = 0; index < size; index++) {
            result[index] = result[index + size] = numbers[index];
        }
        return result;
    }
}