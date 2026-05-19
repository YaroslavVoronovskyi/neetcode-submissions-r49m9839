class Solution {
    public boolean canJump(int[] numbers) {
        int result = numbers.length - 1;
        for (int index = numbers.length - 2; index >= 0; index--) {
            if (index + numbers[index] >= result) {
                result = index;
            }
        }
        return result == 0;
    }
}
