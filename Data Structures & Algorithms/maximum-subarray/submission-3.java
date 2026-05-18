class Solution {

    public int maxSubArray(int[] numbers) {
        int size = numbers.length;
        int[][] array = new int[size][2];
        array[size - 1][1] = array[size - 1][0] = numbers[size - 1];
        for (int index = size - 2; index >= 0; index--) {
            array[index][1] =  Math.max(numbers[index], numbers[index] + array[index + 1][1]);
            array[index][0] =  Math.max(array[index + 1][0], array[index][1]);
        }
        return array[0][0];
    }
}
