class Solution {
    public int[] sortArray(int[] numbers) {
        countingSort(numbers);
        return numbers;
    }

    private void countingSort(int[] numbers) {
        Map<Integer, Integer> count = new HashMap<>();
        int minValue = numbers[0];
        int maxValue = numbers[0];
        for (int index = 0; index < numbers.length; index++) {
            minValue = Math.min(minValue, numbers[index]);
            maxValue = Math.max(maxValue, numbers[index]);
            count.put(numbers[index], count.getOrDefault(numbers[index], 0) + 1);
        }
        int index = 0;
        for (int value = minValue; value <= maxValue; ++value) {
            while (count.getOrDefault(value, 0) > 0) {
                numbers[index] = value;
                index += 1;
                count.put(value, count.get(value) - 1);
            }
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