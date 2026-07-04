class Solution {

    public int subsetXORSum(int[] numbers) {
        return depthFirstSearch(numbers, 0, 0);
    }

    private int depthFirstSearch(int[] numbers, int index, int total) {
        if (index == numbers.length) {
            return total;
        }
        return depthFirstSearch(numbers, index + 1, total ^ numbers[index]) + depthFirstSearch(numbers, index + 1, total);
    }
}