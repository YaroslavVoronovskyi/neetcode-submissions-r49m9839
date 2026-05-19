class Solution {
    public boolean canJump(int[] numbers) {
        Map<Integer, Boolean> memo = new HashMap<>();
        return depthFirstSearch(numbers, 0, memo);
    }

    private boolean depthFirstSearch(int[] numbers, int i, Map<Integer, Boolean> memo) {
        if (memo.containsKey(i)) {
            return memo.get(i);
        }
        if (i == numbers.length - 1) {
            return true;
        }
        if (numbers[i] == 0) {
            return false;
        }
        int end = Math.min(numbers.length - 1, i + numbers[i]);
        for (int j = i + 1; j <= end; j++) {
            if (depthFirstSearch(numbers, j, memo)) {
                memo.put(i, true);
                return true;
            }
        }
        memo.put(i, false);
        return false;
    }
}
