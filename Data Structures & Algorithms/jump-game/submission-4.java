class Solution {
    public boolean canJump(int[] numbers) {
        int goal = numbers.length - 1;
        for (int index = numbers.length - 2; index >= 0; index--) {
            if (index + numbers[index] >= goal) {
                goal = index;
            }
        }
        return goal == 0;
    }
}
