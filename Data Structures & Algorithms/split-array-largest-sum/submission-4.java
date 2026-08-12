class Solution {

    public int splitArray(int[] numbers, int k) {
        int size = numbers.length;
        int[] array = new int[size + 1];
        int[] nextArray = new int[size + 1];
        Arrays.fill(array, Integer.MAX_VALUE);
        array[size] = 0;
        for (int middle = 1; middle <= k; middle++) {
            Arrays.fill(nextArray, Integer.MAX_VALUE);
            for (int i = size - 1; i >= 0; i--) {
                int currentSum = 0;
                for (int j = i; j < size - middle + 1; j++) {
                    currentSum += numbers[j];
                    nextArray[i] = Math.min(nextArray[i], Math.max(currentSum, array[j + 1]));
                }
            }
            int[] temp = array;
            array = nextArray;
            nextArray = temp;
        }
        return array[0];
    }
}