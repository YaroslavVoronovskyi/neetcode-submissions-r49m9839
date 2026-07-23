class Solution {
    public int minSubArrayLen(int target, int[] numbers) {
        int size = numbers.length;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            int curSum = 0;
            int j = i;
            while (j < size) {
                curSum += numbers[j];
                if (curSum >= target) {
                    result = Math.min(result, j - i + 1);
                    break;
                }
                j++;
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}