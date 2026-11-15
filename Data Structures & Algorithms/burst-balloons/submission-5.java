class Solution {
    public int maxCoins(int[] numbers) {
        int size = numbers.length;
        int[] newNumbers = new int[size + 2];
        newNumbers[0] = 1;
        newNumbers[size + 1] = 1;
        for (int index = 0; index < size; index++) {
            newNumbers[index + 1] = numbers[index];
        }

        int[][] cache = new int[size + 2][size + 2];
        for (int left = size; left >= 1; left--) {
            for (int right = left; right <= size; right++) {
                for (int index = left; index <= right; index++) {
                    int coins = newNumbers[left - 1] * newNumbers[index] * newNumbers[right + 1];
                    coins += cache[left][index - 1] + cache[index + 1][right];
                    cache[left][right] = Math.max(cache[left][right], coins);
                }
            }
        }
        return cache[1][size];
    }
}
