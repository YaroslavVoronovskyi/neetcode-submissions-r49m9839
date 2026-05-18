class Solution {

    private Integer[][] memo;

    public int maxSubArray(int[] numbers) {
        memo = new Integer[numbers.length][2];
        return depthFirstSearch(numbers, 0, false);
    }

    private int depthFirstSearch(int[] numbers, int index, boolean flag) {
        if (index == numbers.length - 1) {
            return flag ? Math.max(0, numbers[index]) : numbers[index];
        }
        int f = flag ? 1 : 0;
        if(memo[index][f] != null) {
            return memo[index][f];
        }
        memo[index][f] = flag ? Math.max(0, numbers[index] + depthFirstSearch(numbers, index + 1, true))
                              : Math.max(depthFirstSearch(numbers, index + 1, false), numbers[index] + depthFirstSearch(numbers, index + 1, true));
        return memo[index][f];     
    }
}
