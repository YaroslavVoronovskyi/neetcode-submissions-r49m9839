class Solution {
    public int search(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left <= right) {
            int middle = left + (right - left ) / 2;
            if (numbers[middle] == target) {
                return middle;
            }
            if (numbers[left] <= numbers[middle]) {
                if (target > numbers[middle] || target < numbers[left]) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            } else {
                if (target < numbers[middle] || target > numbers[right]) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            }
        }
        return -1;
    }
}
