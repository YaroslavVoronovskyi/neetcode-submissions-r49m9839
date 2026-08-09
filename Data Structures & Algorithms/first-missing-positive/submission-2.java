class Solution {
    public int firstMissingPositive(int[] numbers) {
        Arrays.sort(numbers);
        int missing = 1;
        for (int number : numbers) {
            if (number > 0 && missing == number) {
                missing++;
            }
        }
        return missing;
    }
}