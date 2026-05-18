class Solution {

    private int[][] array;
    private int totalSum;

    public int findTargetSumWays(int[] numbers, int target) {
        totalSum = 0;
        for (int number : numbers) {
            totalSum += number;
        }
        array = new int[numbers.length][2 * totalSum + 1];
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < 2 * totalSum + 1; j++) {
                array[i][j] = Integer.MIN_VALUE;
            }
        }
        return backtrack(0, 0, numbers, target);
    }

    private int backtrack(int index, int total, int[] numbers, int target) {
        if (index == numbers.length) {
            return total == target ? 1 : 0;
        }
        if (array[index][total + totalSum] != Integer.MIN_VALUE) {
            return array[index][total + totalSum];
        }
        array[index][total + totalSum] = backtrack(index + 1, total + numbers[index], numbers, target) +
                                         backtrack(index + 1, total - numbers[index], numbers, target);
        return array[index][total + totalSum];
    }
}
