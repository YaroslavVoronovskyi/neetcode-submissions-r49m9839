class Solution {
    private int[] prefix;
    private int size;

    public int splitArray(int[] numbers, int k) {
        size = numbers.length;
        prefix = new int[size + 1];
        for (int index = 0; index < size; index++) {
            prefix[index + 1] = prefix[index] + numbers[index];
        }
        int left = Integer.MIN_VALUE;
        int right = 0;
        
        for (int number : numbers) {
            left = Math.max(left, number);
            right += number;
        }
        int result = right;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (canSplit(middle, k)) {
                result = middle;
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return result;
    }

    private boolean canSplit(int largest, int k) {
        int subarrays = 0;
        int index = 0;
        while (index < size) {
            int left = index + 1;
            int right = size;
            while (left <= right) {
                int middle = left + (right - left) / 2;
                if (prefix[middle] - prefix[index] <= largest) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
            subarrays++;
            index = right;
            if (subarrays > k) {
                return false;
            }
        }
        return true;
    }
}