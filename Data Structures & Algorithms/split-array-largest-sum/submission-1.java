class Solution {
    private int[][] array;

    public int splitArray(int[] numbers, int k) {
        int size = numbers.length;
        array = new int[size][k + 1];
        for (int[] item : array) {
            Arrays.fill(item, -1);
        }
        return depthFirstSearch(numbers, 0, k, size);
    }

    private int depthFirstSearch(int[] numbers, int index, int middle, int size) {
        if(index == size) {
            return middle == 0 ? 0 : Integer.MAX_VALUE;
        }
        if (middle == 0) {
            return Integer.MAX_VALUE;
        }
        if (array[index][middle] != -1) {
            return array[index][middle];
        }
        int result = Integer.MAX_VALUE;
        int currentSum = 0;
        for (int j = index; j <= size - middle; j++) {
            currentSum += numbers[j];
            result = Math.min(result, Math.max(currentSum, depthFirstSearch(numbers, j + 1, middle - 1, size)));
        }
        return array[index][middle] = result;
    }
}