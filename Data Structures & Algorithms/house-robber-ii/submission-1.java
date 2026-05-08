class Solution {

    private int[][] memo;

    public int rob(int[] numbers) {
        if (numbers.length == 1) {
            return numbers[0];
        }
        memo = new int[numbers.length][2];
        for (int index = 0; index < numbers.length; index++) {
            memo[index][0] = -1;
            memo[index][1] = -1;
        }
        return Math.max(depthFirstSearch(0, 1, numbers), depthFirstSearch(1, 0, numbers));
    }

    private int depthFirstSearch(int index, int flag, int[] numbers) {
        if (index >= numbers.length || (flag == 1 && index == numbers.length - 1)) {
            return 0;
        }
        if (memo[index][flag] != -1) {
            return memo[index][flag];
        }
        memo[index][flag] = Math.max(depthFirstSearch(index + 1, flag, numbers), numbers[index] + 
                        depthFirstSearch(index + 2, flag | (index == 0 ? 1 : 0), numbers));
        return memo[index][flag];
    }
}
