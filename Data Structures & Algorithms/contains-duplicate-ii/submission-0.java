class Solution {
    public boolean containsNearbyDuplicate(int[] numbers, int k) {
        for (int left = 0; left < numbers.length; left++) {
            for (int right = left + 1; right < Math.min(numbers.length, left + k + 1); right++) {
                if (numbers[left] == numbers[right]) {
                    return true;
                }
            }
        }
        return false;
    }
}