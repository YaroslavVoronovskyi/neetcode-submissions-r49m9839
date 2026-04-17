class Solution {
    public int findDuplicate(int[] numbers) {
        int size = numbers.length;
        int low = 1;
        int high = size - 1;
        while (low < high) {
            int middle = low + (high - low) / 2;
            int lessOrEqual = 0;
            for (int index = 0; index < size; index++) {
                if (numbers[index] <= middle) {
                    lessOrEqual++;
                }
            }
            if (lessOrEqual <= middle) {
                low = middle + 1;
            } else {
                high = middle;
            }
        }
        return low;
    }
}
