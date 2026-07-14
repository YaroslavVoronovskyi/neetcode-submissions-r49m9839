class Solution {
    public int[] sortArray(int[] numbers) {
        quickSort(numbers, 0, numbers.length - 1);
        return numbers;
    }

    private void quickSort(int[] numbers, int left, int right) {
        if (right <= left + 1) {
            if (right == left + 1 && numbers[right] < numbers[left]) {
                swap(numbers, left, right);
            }
            return;
        }
        int j = partition(numbers, left, right);
        quickSort(numbers, left, j - 1);
        quickSort(numbers, j + 1, right);
    }

    private void swap(int[] numbers, int left, int right) {
        int temp = numbers[left];
        numbers[left] = numbers[right];
        numbers[right] = temp;
    }

    private int partition(int[] numbers, int left, int right) {
        int middle = (left + right) >> 1;
        swap(numbers, middle, left + 1);
        if (numbers[left] > numbers[right]) {
            swap(numbers, left, right);
        }
        if (numbers[left + 1] > numbers[right]) {
            swap(numbers, left + 1, right);
        }
        if (numbers[left] > numbers[left + 1]) {
            swap(numbers, left, left + 1);
        }
        int pivot = numbers[left + 1];
        int i = left + 1;
        int j = right;
        while (true) {
            while (numbers[++i] < pivot);
            while (numbers[--j] > pivot);
            if (i > j) {
                break;
            }
            swap(numbers, i, j);
        }
        numbers[left + 1] = numbers[j];
        numbers[j] = pivot;
        return j;
    }
}