class Solution {
    public int search(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length;
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (numbers[middle] >= target) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return (left < numbers.length && numbers[left] == target) ? left : -1;
    }
}
