class Solution {
    public int findMin(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (numbers[middle] < numbers[right]) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return numbers[left];
    }
}
