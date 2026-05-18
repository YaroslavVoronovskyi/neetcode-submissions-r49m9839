class Solution {

    public int maxSubArray(int[] numbers) {
        return depthFirstSearch(numbers, 0, numbers.length - 1);
    }

    private int depthFirstSearch(int[] numbers, int left, int right) {
        if (left > right) {
            return Integer.MIN_VALUE;
        }
        int middle = (left + right) >> 1;
        int leftSum = 0;
        int rightSum = 0;
        int currentSum = 0;
        for (int index = middle - 1; index >= left; index--) {
            currentSum += numbers[index];
            leftSum = Math.max(leftSum, currentSum);
        }
        currentSum = 0;
        for (int index = middle + 1; index <= right; index++) {
            currentSum += numbers[index];
            rightSum = Math.max(rightSum, currentSum);
        }
        return Math.max(depthFirstSearch(numbers, left, middle - 1), 
               Math.max(depthFirstSearch(numbers, middle + 1, right), leftSum + numbers[middle] + rightSum));
    }
}
