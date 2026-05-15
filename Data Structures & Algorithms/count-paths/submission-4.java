class Solution {

    public int uniquePaths(int m, int n) {
        int[] array = new int[n];
        Arrays.fill(array, 1);
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                array[j] += array[j + 1];
            }
        }
        return array[0];
    }
}
