class Solution {
    public boolean canJump(int[] numbers) {
        int size = numbers.length;
        boolean[] array = new boolean[size];
        array[size - 1] = true;
        for (int i = size - 2; i >= 0; i--) {
            int end = Math.min(size, i + numbers[i] + 1);
            for (int j = i + 1; j < end; j++) {
                if (array[j]) {
                    array[i] = true;
                    break;
                }
            }
        }
        return array[0];
    }
}
