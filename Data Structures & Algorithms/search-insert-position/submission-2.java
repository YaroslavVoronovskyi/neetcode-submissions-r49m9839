class Solution {
    public int searchInsert(int[] numbers, int target) {
        int result = numbers.length;
        int left = 0;
        int right = numbers.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (numbers[middle] == target) {
                return middle;
            }
            if (numbers[middle] > target) {
                result = middle;
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return result;
    }
}