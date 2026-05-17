class Solution {
    public int findTargetSumWays(int[] numbers, int target) {
        return backtrack(0, 0 , numbers, target);
    }

    private int backtrack(int index, int total, int[] numbers, int target) {
        if (index == numbers.length) {
            return total == target ? 1 : 0;
        }
        return backtrack(index + 1, total + numbers[index], numbers, target) + 
               backtrack(index + 1, total - numbers[index], numbers, target);
    }
}
