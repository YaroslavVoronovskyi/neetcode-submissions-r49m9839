class Solution {
    public int[] getConcatenation(int[] numbers) {
        int[] result = new int[numbers.length * 2];
        for (int index = 0; index < numbers.length; index++) {
            result[index] = numbers[index];
            result[index + numbers.length] = numbers[index];
        }
        return result;
    }
}