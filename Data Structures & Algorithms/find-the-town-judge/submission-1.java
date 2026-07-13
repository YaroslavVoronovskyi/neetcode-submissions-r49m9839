class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] delta = new int[n + 1];

        for (int[] item : trust) {
            delta[item[0]] -= 1;
            delta[item[1]] += 1;
        } 
        for (int index = 1; index <= n; index++) {
            if (delta[index] == n - 1) {
                return index;
            }
        }
        return -1;
    }
}