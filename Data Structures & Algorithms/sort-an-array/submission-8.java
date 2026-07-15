class Solution {
    public int[] sortArray(int[] numbers) {
        int size = numbers.length;
        if (size == 1) {
            return numbers;
        }
        shellSort(numbers, size);
        return numbers;
    }

    private void shellSort(int[] numbers, int size) {
        int gap = size / 2;
        while (gap >= 1) {
            for (int i = gap; i < size; i++) {
                int temp = numbers[i];
                int j = i - gap;
                while (j >= 0 && numbers[j] > temp) {
                    numbers[j + gap] = numbers[j];
                    j -= gap;
                }
                numbers[j + gap] = temp;
            }
            gap /= 2;
        }
    }
}