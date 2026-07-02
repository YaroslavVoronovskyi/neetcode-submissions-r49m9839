class Solution {
    public int searchInsert(int[] numbers, int target) {
        for (int index = 0; index < numbers.length; index++) {
            if (numbers[index] >= target) {
                return index;
            }
        }
        return numbers.length;
    }
}