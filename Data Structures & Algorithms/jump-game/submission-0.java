class Solution {
    public boolean canJump(int[] numbers) {
        return depthFirstSearch(numbers, 0);
    }

    private boolean depthFirstSearch(int[] numbers, int i) {
        if (i == numbers.length - 1) {
            return true;
        }
        int end = Math.min(numbers.length - 1, i + numbers[i]);
        for (int j = i + 1; j <= end; j++) {
            if (depthFirstSearch(numbers, j)) {
                return true;
            }
        }
        return false;
    }
}
