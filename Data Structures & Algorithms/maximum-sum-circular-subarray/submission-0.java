class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int size = nums.length;
        int result = nums[0];

        for (int i = 0; i < size; i++) {
            int currentSum = 0;
            for (int j = i; j < i + size; j++) {
                currentSum += nums[j % size];
                result = Math.max(result, currentSum);
            }
        }
        return result;
    }
}