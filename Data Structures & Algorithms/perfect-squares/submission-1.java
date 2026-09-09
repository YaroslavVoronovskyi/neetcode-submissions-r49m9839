class Solution {
    public int numSquares(int n) {
        int[] array = new int[n + 1];
        Arrays.fill(array, n);
        array[0] = 0;
        for (int target = 1; target <= n; target++) {
            for (int index = 1; index * index <= target; index++) {
                array[target] = Math.min(array[target], 1 + array[target - index * index]);
            }
        }
        return array[n];
    }
}