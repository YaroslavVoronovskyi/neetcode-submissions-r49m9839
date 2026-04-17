class Solution {
    public int findDuplicate(int[] numbers) {
        for (int number : numbers) {
            int index = Math.abs(number) - 1;
            if (numbers[index] < 0) {
                return Math.abs(number);
            }
            numbers[index] *= -1;
        }
        return -1;
    }
}
