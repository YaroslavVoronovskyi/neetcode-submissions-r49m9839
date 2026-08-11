class Solution {

    public int splitArray(int[] numbers, int k) {
        int size = numbers.length;
        int[][] array = new int[size + 1][k + 1];
        for (int[] item : array) {
            Arrays.fill(item, Integer.MAX_VALUE);
        }
        array[size][0] = 0;
        for (int middle = 1; middle <= k; middle++) {
            for (int i = size - 1; i >= 0; i--) {
                int currentSum = 0;
                for (int j = i; j < size - middle + 1; j++) {
                    currentSum += numbers[j];
                    array[i][middle] = Math.min(array[i][middle], Math.max(currentSum, array[j + 1][middle - 1]));
                }
            }
        }
        return array[0][k];
    }
}