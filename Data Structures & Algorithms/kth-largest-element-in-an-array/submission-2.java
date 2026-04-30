class Solution {
    public int findKthLargest(int[] numbers, int key) {
        key = numbers.length - key;
        return quickSelect(numbers, 0, numbers.length - 1, key);
    }

    private int quickSelect(int[] numbers, int left, int right, int key) {
        int pivot = numbers[right];
        int p = left;

        for (int index = left; index < right; index++) {
            if (numbers[index] <= pivot) {
                int temp = numbers[p];
                numbers[p] = numbers[index];
                numbers[index] = temp;
                p++;
            }
        }
        int temp = numbers[p];
        numbers[p] = numbers[right];
        numbers[right] = temp;

        if (p > key) {
            return quickSelect(numbers, left, p - 1, key);
        } else if (p < key) {
            return quickSelect(numbers, p + 1, right, key);
        } else {
            return numbers[p];
        }
    }
}
