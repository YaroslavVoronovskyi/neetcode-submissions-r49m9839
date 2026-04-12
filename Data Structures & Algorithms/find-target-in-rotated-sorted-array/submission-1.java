class Solution {
    public int search(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int middle = (left + right) / 2;
            if (numbers[middle] > numbers[right]) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }

        int pivot = left;
        int result = binarySearch(numbers, target, 0, pivot - 1);
        if (result != -1) {
            return result;
        }

        return binarySearch(numbers, target, pivot, numbers.length - 1);
    }

    private int binarySearch(int[] numbers, int target, int left, int right) {
        while (left <= right) {
            int middle = (left + right) / 2;
            if (numbers[middle] == target) {
                return middle;
            } else if (numbers[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }
}
