class Solution {
    public int searchInsert(int[] numbers, int target) {
        int index = Arrays.binarySearch(numbers, target);
        return index >= 0 ? index : -index - 1;
    }
}