class Solution {
    public int subarraySum(int[] numbers, int k) {
        int result = 0;
        for (int i = 0; i < numbers.length; i++) {
            int sum = 0;
            for (int j = i; j < numbers.length; j++) {
                sum += numbers[j];
                if (sum == k) {
                    result++;
                }
            }
        }
        return result;
    }
}