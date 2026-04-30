class Solution {
    public int findKthLargest(int[] numbers, int key) {
        return quickSelect(numbers, key - 1);
    }

    private int quickSelect(int[] numbers, int key) {
        int left = 0;
        int right = numbers.length - 1;

        while (true) {
            if (right <= left + 1) {
                if (right == left + 1 && numbers[right] > numbers[left]) {
                    swap(numbers, left, right);
                }
                return numbers[key];
            }
            int index = partition(numbers, left, right);
            if (index >= key) {
                right = index - 1;
            }
            if (index <= key) {
                left = index + 1;
            }
        }

    }

    private int partition(int[] numbers, int left, int right) {
        int middle = (left + right) >> 1;
        swap(numbers, middle, left + 1);

        if (numbers[left] < numbers[right]) {
            swap(numbers, left, right);
        }
        if (numbers[left + 1] < numbers[right]) {
            swap(numbers, left + 1, right);
        }
        if (numbers[left] < numbers[left + 1]) {
            swap(numbers, left, left + 1);
        }

        int pivot = numbers[left + 1];
        int i = left + 1;
        int j = right;

        while (true) {
            while (numbers[++i] > pivot) ;
            while (numbers[--j] < pivot) ;
            if (i > j) {
                break;
            }
            swap(numbers, i, j);
        }

        numbers[left + 1] = numbers[j];
        numbers[j] = pivot;
        return j;
    }

    private void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}
