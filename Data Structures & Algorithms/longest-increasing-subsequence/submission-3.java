class Solution {

    public int lengthOfLIS(int[] numbers) {
        int size = numbers.length;
        int[][] array = new int[size + 1][size + 1];
        
        for (int i = size - 1; i >= 0; i--) {
            for (int j = i - 1; j >= -1; j--) {
                int result = array[i + 1][j + 1];
                if (j == -1 || numbers[j] < numbers[i]) {
                    result = Math.max(result, 1 + array[i + 1][i + 1]);
                }
                array[i][j + 1] = result;
            }
        }
        return array[0][0];
    }
}
