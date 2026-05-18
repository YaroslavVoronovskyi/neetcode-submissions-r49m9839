class Solution {
    public int maxSubArray(int[] numbers) {
        return depthFirstSearch(numbers, 0, false);
    }

    private int depthFirstSearch(int[] numbers, int index, boolean flag) {
        if (index == numbers.length - 1) {
            return flag ? Math.max(0, numbers[index]) : numbers[index];
        }
        if(flag) {
            return Math.max(0, numbers[index] + depthFirstSearch(numbers, index + 1, true));
        }
        return Math.max(depthFirstSearch(numbers, index + 1, false), numbers[index] + depthFirstSearch(numbers, index + 1, true));
    }
}
