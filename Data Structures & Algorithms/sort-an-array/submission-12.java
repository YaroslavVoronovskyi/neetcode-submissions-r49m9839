class Solution {
    public int[] sortArray(int[] numbers) {
        quickSort(0, numbers.length - 1, numbers);
        return numbers;
    }

    private void quickSort(int left, int right, int[] numbers) {
        if (right - left <= 0) {
            return;
        } else {
            int pivot = numbers[right];
            int partition = partition(left, right, pivot, numbers);
            quickSort(left, partition - 1, numbers);
            quickSort(partition + 1, right, numbers);
        }
    }

    private int partition(int left, int right, int pivot, int[] numbers) {
        int leftPart = left - 1;
        int rightPart = right;
        while (true) {
            while (numbers[++leftPart] < pivot) {
                ;
            }
            while (rightPart > 0 && numbers[--rightPart] > pivot) {
                ;
            }
            if (leftPart >= rightPart) {
                break;
            } else {
                swap(leftPart, rightPart, numbers);
            }
        }
        swap(leftPart, right, numbers);
        return leftPart;
    }

    private void swap(int dex1, int dex2, int[] numbers) {
        int temp = numbers[dex1];
        numbers[dex1] = numbers[dex2];
        numbers[dex2] = temp;
    }
}