class Solution {
    public int uniquePaths(int m, int n) {
        int[] cache = new int[n];
        Arrays.fill(cache, 1);
        for (int outer = m - 2; outer >= 0; outer--) {
            for (int inner = n - 2; inner >= 0; inner--) {
                cache[inner] += cache[inner + 1];
            }
        }
        return cache[0];
    }
}
