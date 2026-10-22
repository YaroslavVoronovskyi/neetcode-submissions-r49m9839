class Solution {
    public int findMaxConsecutiveOnes(int[] numbers) {
        int result = 0;
        int max = 0;
        for (int index = 0; index < numbers.length; index++) {
            if (numbers[index] == 0) {
                result = Math.max(result, max);
                max = 0;
            } else {
                max++;
            }
        }
        return Math.max(result, max);
    }
}