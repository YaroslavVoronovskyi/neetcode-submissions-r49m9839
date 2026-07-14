class Solution {
    public int[] sortArray(int[] numbers) {
        heapSort(numbers);
        return numbers;
    }

    private void heapSort(int[] numbers) {
        int size = numbers.length;
        for (int index = size / 2 - 1; index >= 0; index--) {
            heapify(numbers, size, index);
        }
        for (int index = size - 1; index > 0; index--) {
            int temp = numbers[0];
            numbers[0] = numbers[index];
            numbers[index] = temp;
            heapify(numbers, index, 0);
        }
    }

    private void heapify(int[] numbers, int size, int index) {
        int left = (index << 1)  + 1;
        int right = (index << 1) + 2;
        int largestNode = index;
        if (left < size && numbers[left] > numbers[largestNode]) {
            largestNode = left;
        }
        if (right < size && numbers[right] > numbers[largestNode]) {
            largestNode = right;
        }
        if (largestNode != index) {
            int temp = numbers[index];
            numbers[index] = numbers[largestNode];
            numbers[largestNode] = temp;
            heapify(numbers, size, largestNode);
        }
    }
}