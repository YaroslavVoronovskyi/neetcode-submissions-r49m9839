class Solution {

    public int splitArray(int[] numbers, int k) {
        int left = 0;
        int right = 0;
        int result = 0;
        for (int number : numbers) {
            left = Math.max(left, number);
            right += number;
        }
        result = right;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (canSplit(numbers, k, middle)) {
                result = middle;
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return result;
    }

    private boolean canSplit(int[] numbers, int k, int largest) {
        int subarray = 1;
        int currentSum = 0;
        for (int number : numbers) {
            currentSum += number;
            if (currentSum > largest) {
                subarray++;
                if (subarray > k) {
                    return false;
                }
                currentSum = number;
            }
        }
        return true;
    }
}