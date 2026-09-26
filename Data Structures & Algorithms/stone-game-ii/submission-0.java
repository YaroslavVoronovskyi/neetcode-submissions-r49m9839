class Solution {
    public int stoneGameII(int[] piles) {
        int size = piles.length;
        int[] suffixSum = new int[size];
        suffixSum[size - 1] = piles[size - 1];
        for (int index = size - 2; index >= 0; index--) {
            suffixSum[index] = piles[index] + suffixSum[index + 1];
        }
        int[][] cache = new int[size + 1][size + 1];
        for (int index = size - 1; index >= 0; index--) {
            for (int m = 1; m <= size; m++) {
                for (int x = 1; x <= 2 * m; x++) {
                    if (index + x > size) {
                        break;
                    }
                    cache[index][m] = Math.max(cache[index][m], suffixSum[index] - cache[index + x][Math.max(m, x)]);
                }
            }
        }
        return cache[0][1];
    }
}