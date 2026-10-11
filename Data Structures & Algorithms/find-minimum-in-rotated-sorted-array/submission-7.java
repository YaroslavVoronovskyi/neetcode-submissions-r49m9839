class Solution {
    public int findMin(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        int min = numbers[0];
        while (left <= right) {
            if (numbers[left] < numbers[right]) {
                min = Math.min(min, numbers[left]);
                break;
            } 
            int middle = left + (right - left) / 2;
            min = Math.min(min, numbers[middle]);
            if (numbers[middle] >= numbers[left]) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return min;
    }
}
