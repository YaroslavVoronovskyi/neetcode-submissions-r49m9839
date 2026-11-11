class Solution {
    public int lengthOfLIS(int[] numbers) {
        int size = numbers.length;
        int[][] cache = new int[size + 1][size + 1];
        for (int outer = size - 1; outer >= 0; outer--) {
            for (int inner = outer - 1; inner >= -1; inner--) {
                int count = cache[outer + 1][inner + 1];
                if (inner == -1 || numbers[inner] < numbers[outer]) {
                    count = Math.max(count, 1 + cache[outer + 1][outer + 1]);
                }
                cache[outer][inner + 1] = count;
            }
        }
        return cache[0][0];
    }
}
