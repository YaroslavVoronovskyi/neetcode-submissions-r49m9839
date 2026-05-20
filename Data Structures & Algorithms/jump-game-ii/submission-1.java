class Solution {
    public int jump(int[] numbers) {
        Map<Integer, Integer> memo = new HashMap<>();
        return depthFirstSearch(numbers, 0, memo);
    }

    private int depthFirstSearch(int[] numbers, int index, Map<Integer, Integer> memo) {
        if (memo.containsKey(index)) {
            return memo.get(index);
        }
        if (index == numbers.length - 1) {
            return 0;
        }
        if (numbers[index] == 0) {
            return 1000000;
        }
        int result = 1000000;
        int end = Math.min(numbers.length, index + numbers[index] + 1);
        for (int j = index + 1; j < end; j++) {
            result = Math.min(result, 1 + depthFirstSearch(numbers, j, memo));
        }
        memo.put(index, result);
        return result;
    }
}
