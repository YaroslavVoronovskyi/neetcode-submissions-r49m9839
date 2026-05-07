class Solution {

    public int rob(int[] numbers) {
        if (numbers.length == 0) {
            return 0;
        }
        if (numbers.length == 1) {
            return numbers[0];
        }
        int[] result = new int[numbers.length];
        result[0] = numbers[0];
        result[1] = Math.max(numbers[0], numbers[1]);
        for (int index = 2; index < numbers.length; index++) {
            result[index] = Math.max(result[index - 1], numbers[index] + result[index - 2]);
        }
        return result[numbers.length - 1];
    }
}
