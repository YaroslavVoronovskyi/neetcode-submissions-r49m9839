class Solution {
    public int minSubArrayLen(int target, int[] numbers) {
        int size = numbers.length;
        int[] prefixSum = new int[size + 1];
        for (int index = 0; index < size; index++) {
            prefixSum[index + 1] = prefixSum[index] + numbers[index];
        }
        int result = size + 1;
        for (int index = 0; index < size; index++) {
            int left = index;
            int right = size;
            while (left < right) {
                int middle = (left + right) / 2;
                int curSum = prefixSum[middle + 1] - prefixSum[index];
                if (curSum >= target) {
                    right = middle;
                } else {
                    left = middle + 1;
                }
            }
            if (left != size) {
                result = Math.min(result, left - index + 1);
            }
        }
        return result % (size + 1);
    }
}