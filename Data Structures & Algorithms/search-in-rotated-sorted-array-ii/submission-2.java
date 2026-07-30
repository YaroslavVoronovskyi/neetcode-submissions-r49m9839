class Solution {
    public boolean search(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (numbers[middle] == target) {
                return true;
            }
            if (numbers[left] < numbers[middle]) {
                if (numbers[left] <= target && target < numbers[middle]) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            } else if (numbers[left] > numbers[middle]) {
                if (numbers[middle] < target && target <= numbers[right]) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            } else {
                left++;
            }
        }
        return false;
    }
}