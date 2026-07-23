class Solution {
    public int minSubArrayLen(int target, int[] numbers) {
        int size = numbers.length;
        int left = 0;
        int total = 0;
        int result = Integer.MAX_VALUE;
        for (int right = 0; right < size; right++) {
            total += numbers[right];
            while (total >= target) {
                result = Math.min(right - left + 1, result);
                total -= numbers[left];
                left++;
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}