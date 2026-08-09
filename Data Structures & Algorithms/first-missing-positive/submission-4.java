class Solution {
    public int firstMissingPositive(int[] numbers) {
        int size = numbers.length;
        int i = 0;
        while (i < size) {
            if (numbers[i] <= 0 || numbers[i] > size) {
                i++;
                continue;
            }
            int index = numbers[i] - 1;
            if (numbers[i] != numbers[index]) {
                int temp = numbers[i];
                numbers[i] = numbers[index];
                numbers[index] = temp;
            } else {
                i++;
            }
        }
        for (int index = 0; index < size; index++) {
            if (numbers[index] != index + 1) {
                return index + 1;
            }
        }
        return size + 1;
    }
}