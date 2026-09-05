class Solution {
    public int[] getConcatenation(int[] numbers) {
        int size = numbers.length;
        int[] result = new int[size * 2];
        System.arraycopy(numbers, 0, result, 0, size);
        System.arraycopy(numbers, 0, result, size, size);
        return result;
    }
}