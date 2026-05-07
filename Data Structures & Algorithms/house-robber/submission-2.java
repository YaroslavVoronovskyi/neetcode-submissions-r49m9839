class Solution {

    private int[] memo;

    public int rob(int[] numbers) {
        memo = new int[numbers.length];
        Arrays.fill(memo, -1);
        return depthFirstSearch(numbers, 0);
    }

    private int depthFirstSearch(int[] numbers, int index) {
        if (index >= numbers.length) {
            return 0;
        }
        if (memo[index] != -1) {
            return memo[index];
        }
        memo[index] = Math.max(depthFirstSearch(numbers, index + 1), 
        numbers[index] + depthFirstSearch(numbers, index + 2));
        return memo[index];
    }
}
