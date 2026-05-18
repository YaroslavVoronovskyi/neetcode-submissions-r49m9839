class Solution {

    public int maxSubArray(int[] numbers) {
        int maxSub = numbers[0];
        int currentSum = 0;
        for (int sum : numbers) {
            if (currentSum < 0) {
                currentSum = 0;
            }
            currentSum += sum;
            maxSub = Math.max(maxSub, currentSum);
        }
        return maxSub;
    }
}
