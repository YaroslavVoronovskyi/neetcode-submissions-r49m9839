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
        for (int row = 0; row <= size; row++) {
            for (int col = 0; col <= size; col++) {
                cache[row][col] = -1;
            }
        }

        return depthFirstSearch(newNumbers, 1, newNumbers.length - 2, cache);
    }

    public int depthFirstSearch(int[] numbers, int left, int right, int[][] cache) {
        if (left > right) {
            return 0;
        }
        if (cache[left][right] != -1) {
            return cache[left][right];
        }
        cache[left][right] = 0;
        for (int index = left; index <= right; index++) {
            int coins = numbers[left - 1] * numbers[index] * numbers[right + 1];
            coins += depthFirstSearch(numbers, left, index - 1, cache) + depthFirstSearch(numbers, index + 1, right, cache);
            cache[left][right] = Math.max(cache[left][right], coins);
        }
        return cache[left][right];
    }
}
