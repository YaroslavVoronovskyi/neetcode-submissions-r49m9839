class Solution {
    public long minEnd(int n, int x) {
        long result = x;
        for (int index = 0; index < n - 1; index++) {
            result = (result + 1) | x;
        }
        return result;
    }
}