class Solution {
    public int missingNumber(int[] numbers) {
        int result = numbers.length;
        for (int index = 0; index < numbers.length; index++) {
            result += index - numbers[index];
        }
        return result;
    }
}
