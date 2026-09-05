class Solution {
    public int[] getConcatenation(int[] numbers) {
        int size = numbers.length;
        int[] result = new int[size * 2];
        int idx = 0;
        for (int index = 0; index < 2; index++) {
            for(int number : numbers) {
                result[idx++] = number;
            }
        }
        return result;
    }
}