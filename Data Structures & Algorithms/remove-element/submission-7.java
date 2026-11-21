class Solution {
    public int removeElement(int[] numbers, int value) {
        int result = 0;
        for (int index = 0; index < numbers.length; index++) {
            if (numbers[index] != value) {
                numbers[result] = numbers[index];
                result++;
            }
        }
        return result;
    }
}