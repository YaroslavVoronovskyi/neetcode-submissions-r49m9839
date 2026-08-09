class Solution {
    public int firstMissingPositive(int[] numbers) {
        int size = numbers.length;
        for (int index = 0; index < size; index++) {
            if (numbers[index] < 0) {
                numbers[index] = 0;
            }
        }
        for (int index = 0; index < size; index++) {
            int val = Math.abs(numbers[index]);
            if (val >= 1 && val <= size) {
                if (numbers[val - 1] > 0) {
                    numbers[val - 1] *= -1;
                } else if (numbers[val - 1] == 0) {
                    numbers[val - 1] = -1 * (size + 1);
                }
            }
        }
        for (int index = 1; index <= size; index++) {
            if (numbers[index -1] >= 0) {
                return index;
            }
        }
        return size + 1;
    }
}