class Solution {
    public int search(int[] numbers, int target) {
        return binarySearch(0, numbers.length - 1, numbers, target);
    }

    public int binarySearch(int left, int right, int[] numbers, int target) {
        if (left > right) {
            return -1;
        }
        int middle = left + (right - left) / 2;
        if (numbers[middle] == target) {
            return middle;
        }
        return (numbers[middle] < target) ?
                binarySearch(middle + 1, right, numbers, target) :
                binarySearch(left, middle - 1, numbers, target);
    }
}
