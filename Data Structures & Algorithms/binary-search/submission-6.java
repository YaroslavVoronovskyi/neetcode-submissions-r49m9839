class Solution {
    public int search(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left <= right) {
            int middle = left + ((right - left) / 2);
            if (numbers[middle] > target) {
                right = middle - 1;
            } else if (numbers[middle] < target) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }
}
