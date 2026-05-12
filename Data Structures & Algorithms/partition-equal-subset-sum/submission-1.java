class Solution {

    Boolean[][] memo;

    public boolean canPartition(int[] numbers) {
        int size = numbers.length;
        int sum = 0;
        for (int index = 0; index < size; index++) {
            sum += numbers[index];
        }
        if (sum % 2 != 0) {
            return false;
        }
        memo = new Boolean[size][sum / 2 + 1];
        return depthFirstSearch(numbers, 0, sum / 2);
    }

    public boolean depthFirstSearch(int[] numbers, int index, int target) {
        if (index == numbers.length) {
            return target == 0;
        }
        if (target < 0) {
            return false;
        }
        if (memo[index][target] != null) {
            return memo[index][target];
        }
        memo[index][target] = depthFirstSearch(numbers, index + 1, target) ||
                              depthFirstSearch(numbers, index + 1, target - numbers[index]);
        return memo[index][target];
    }
}
